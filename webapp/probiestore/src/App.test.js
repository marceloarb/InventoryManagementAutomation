import React from 'react';
import App from './App';
import shallow from 'enzyme';

it('smoke', () => {
    shallow.render(<App/>);
});
