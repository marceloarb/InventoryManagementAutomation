import getProducts from '../../service/productsRequest';


function parseProductPrice(productPrice) {
    return (!productPrice || productPrice < 0) ? "AVAILABLE SOON" :"$ "+ new Intl.NumberFormat('en-US', { minimumFractionDigits: 2 }).format(productPrice);
    
    // let price = parseFloat(productPrice.split(',').join(''));
    // return price >= 0 ? "$ " + productPrice : "AVAILABLE SOON"
}

async function getProductsRepo() {
    let productList = [];
    try {
        let response = await getProducts();
        for (let i = 0; i < response.length; i++) {
            if (response[i].name == null) {
                response[i].name = "[unknown]";
            }
            response[i].price = parseProductPrice(response[i].price);
            productList.push(response[i]);
        }
    } catch (error) {
        console.error(error);
    }
    return productList
}

export default getProductsRepo;
