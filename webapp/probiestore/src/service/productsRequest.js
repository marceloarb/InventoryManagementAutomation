import axios from 'axios';

async function getProducts() {
    try {
        var response = await axios.get('http://localhost:8080/products');
        return response.data;
    } catch (error) {
        console.error(error);
    }
    return [];
}
export default getProducts;
