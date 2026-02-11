const { DashboardPageElements } = require("../../PageObjects/PageActions/DashboardPage");
const { LoginPageElements } = require("../../PageObjects/PageActions/LoginPageActions");
const { ProductPageElements } = require("../../PageObjects/PageActions/ProductPageActions");

beforeEach(()=>{
  cy.visit('/')

})
const dashboard=new DashboardPageElements
const product=new ProductPageElements
const login=new LoginPageElements

describe('assignment', () => {
  it('Verify that the selected product is being displayed', () => {
    cy.login('standard_user','secret_sauce');
//Confirms that it lands on the page with the proper header  
    dashboard.header();
//Verification for invalid credentials and url
    cy.contains('Epic sadface: Username and password do not match any user in this service').should('not.exist')
    cy.url().should('eq','https://www.saucedemo.com/inventory.html')
//Selecting a particular item
    cy.item_selection()
//verification
product.verify_item_name();
    cy.url().should('eq','https://www.saucedemo.com/inventory-item.html?id=4');
    })
  })


it('To verify that Invalid Credentials cannot login', () => {
  cy.visit('/')
  cy.login('admin','admin1234')
  cy.wait(2000);
login.verifyerror();
cy.url().should('eq','https://www.saucedemo.com/')
})



