import { shallow } from "enzyme";
import React from "react";

export function renderComponent(component) {
    return shallow(component);
}

export function getElementById(component, value) {

    return renderComponent(component).find(`[id="${value}"]`).text()
}

export function getElementsByClassName(component, value) {
    return renderComponent(component).find(`[className="${value}"]`)
}

// function parseProductPrice(productPrice) {
//     let price = parseFloat(productPrice.split(',').join(''));
//     return price >= 0 ? productPrice : "AVAILABLE SOON"
// }

export function getProduct(classNames, productWrapper) {
    let productName = productWrapper.find(`.${classNames.productName}`).text()
    let productId = productWrapper.find(`.${classNames.productId}`).text()
    let productPrice = productWrapper.find(`.${classNames.productPrice}`).text()
    productId = productId !== '' ? parseInt(productId) : productId
    //productPrice = parseProductPrice(productPrice);
    let product = { "name": productName, "id": productId, "price": productPrice };
    return product;
}
export function getProductList(component, classNames, mockData) {
    let productList = [];
    const mockSetProductList = jest.fn();
    React.useState = jest.fn(() => [mockData, mockSetProductList]);

    for (let i = 0; i < getElementsByClassName(component, classNames.productDiv).length; i++) {
        let productWrapper = getElementsByClassName(component, classNames.productDiv).at(i)
        let product = getProduct(classNames, productWrapper)
        productList.push(product)
    }
    return productList;
}