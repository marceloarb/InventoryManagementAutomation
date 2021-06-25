import getProducts from '../service/productsRequest'
import axios from 'axios'

jest.mock('axios')

describe('TestGetProducts', () => {
    it('makes an axios call', async () => {
        const testData = [
            {
                id: 1,
                name: "Matilda",
                price: null
            },
            {
                id: 2,
                name: null,
                price: 9.99
            },{
                id: 3,
                name: "Neagan",
                price: -9.99
            },
        ];

        const response = { data: testData }
        axios.get.mockImplementationOnce(() => Promise.resolve(response));
        const expected = testData;
        const actual = await getProducts();
        expect(actual).toEqual(expected);
    })
})

