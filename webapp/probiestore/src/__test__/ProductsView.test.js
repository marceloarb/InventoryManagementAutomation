import React from 'react';
import ProductsView from '../component/view/products/ProductsView';
import { getElementById, getProductList } from './RenderJestComponent'

const classNames = {
  "productDiv": "product",
  "productId": "product-id",
  "productName": "product-name",
  "productPrice": "product-price"
}

const scenarios = [{
  "id": 1,
  "name": "Matilda",
  "price": "AVAILABLE SOON"
},
{
  "id": null,
  "name": "Charlie",
  "price": "AVAILABLE SOON"
},
{
  "id": null,
  "name": "Mark",
  "price": "AVAILABLE SOON"
},
{
  "id": 2,
  "name": "[unknown]",
  "price": "AVAILABLE SOON"
},
{
  "id": 3,
  "name": "No Comma",
  "price": "AVAILABLE SOON"
}]

const expected = [{
  "id": 1,
  "name": "Matilda",
  "price": "AVAILABLE SOON"
}, {
  "id": "",
  "name": "Charlie",
  "price": "AVAILABLE SOON"
}, {
  "id": "",
  "name": "Mark",
  "price": "AVAILABLE SOON"
}, {
  "id": 2,
  "name": "[unknown]",
  "price": "AVAILABLE SOON"
}, {
  "id": 3,
  "name": "No Comma",
  "price": "AVAILABLE SOON"
}]

test("verify product name label", () => {
  const expected = "Product name";
  const actual = getElementById(<ProductsView />, 'title');
  expect(actual).toBe(expected);
})

test.each([
  [scenarios, expected],
  [[], []]
])
  ("verify product list populated", (testData, expected) => {
    const actual = getProductList(<ProductsView />, classNames, testData);
    expect(actual).toEqual(expected);
  })

