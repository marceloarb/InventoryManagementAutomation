import React from 'react';
import './App.css';
import ProductsView from "./component/view/products/ProductsView";
import {BrowserRouter, Route, Switch} from "react-router-dom";

function App() {
    return (
        <React.Fragment>
            <BrowserRouter>
                <Switch>
                    <Route exact path="/" component={ProductsView}/>
                </Switch>
            </BrowserRouter>
        </React.Fragment>
    );
}

export default App;
