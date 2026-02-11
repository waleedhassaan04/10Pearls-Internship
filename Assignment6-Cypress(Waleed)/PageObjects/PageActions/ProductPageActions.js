const ProductElementsLocators=require('../PageElements/ProductPageElements.json')
export class ProductPageElements{

    
verify_item_name(){
    cy.get(ProductElementsLocators.ProductPageLocators.item).contains('Sauce Labs Backpack');
}

}