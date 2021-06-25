import getProductsRepo from "../component/repository/productRepository";
import getProducts from "../service/productsRequest";
jest.mock("../service/productsRequest");

describe("TestProductRepo", () => {
  it("successfully returns a productList", async () => {
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
      },
      {
        id: 3,
        name: "Neagan",
        price: -9.99
      },
      {
        id: 4,
        name: "Comet",
        price: 9999.99
      },
      {
        id: 5,
        name: "Milly",
        price: 9999999.99
      },
      {
        id: 6,
        name: "Syed",
        price: 0
      },
      {
        id: 7,
        name: "Jose",
        price: 10
      },
      {
        id: 8,
        name: "Sabitha",
        price: 0.50
      }
    
    ];

    getProducts.mockImplementation(() => testData);
    const actual = await getProductsRepo();
    const expected = [
      {
        id: 1,
        name: "Matilda",
        price: "AVAILABLE SOON"
      },
      {
        id: 2,
        name: "[unknown]",
        price: "$ 9.99"
      },
      {
        id: 3,
        name: "Neagan",
        price: "AVAILABLE SOON"
      },
      {
        id: 4,
        name: "Comet",
        price: "$ 9,999.99"
      },
      {
        id: 5,
        name: "Milly",
        price: "$ 9,999,999.99"
      },
      {
        id: 6,
        name: "Syed",
        price: "AVAILABLE SOON"
      },
      {
        id: 7,
        name: "Jose",
        price: "$ 10.00"
      },
      {
        id: 8,
        name: "Sabitha",
        price: "$ 0.50"
      }
    ];
    
    expect(actual).toEqual(expected);
  });
});
