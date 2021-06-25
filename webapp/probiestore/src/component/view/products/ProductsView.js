import React, { useEffect } from 'react';
import getProductsRepo from '../../repository/productRepository';

function ProductsView() {

    const [productList, setProductList] = React.useState([]);

    useEffect(() => {
        async function fetchProductsData() {
            try {
                const asyncResponse = await getProductsRepo();
                setProductList(asyncResponse);
            } catch (error) {
                console.error(error);
            }
        }
        fetchProductsData();
    }, []);

    return (
        <div className='App'>
            <h1 id="title">
                Product name
            </h1>
            <div>
                {productList.map((product) => {
                    return <div key={product.id} className="product">
                        <div className="product-name" >
                            {product.name}
                        </div>
                        <div className="product-id" >
                            {product.id}
                        </div>
                        <div className="product-price" >
                             {product.price}
                        </div>
                    </div>
                })}
            </div>
        </div>
    );
}

export default ProductsView;