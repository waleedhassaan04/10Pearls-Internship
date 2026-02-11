// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************
//
//
// -- This is a parent command --
// Cypress.Commands.add('login', (email, password) => { ... })
//
//
// -- This is a child command --
// Cypress.Commands.add('drag', { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add('dismiss', { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This will overwrite an existing command --

const { DashboardPageElements } = require("../../PageObjects/PageActions/DashboardPage");
const { LoginPageElements } = require("../../PageObjects/PageActions/LoginPageActions")

// Cypress.Commands.overwrite('visit', (originalFn, url, options) => { ... })
const Login_Elements=new LoginPageElements
const dashboard=new DashboardPageElements
Cypress.Commands.add('login',(username,password)=>{
   Login_Elements.username(username);
   Login_Elements.password(password);
   Login_Elements.loginButton();

})
Cypress.Commands.add('item_selection',()=>{
   dashboard.select_item();
})

