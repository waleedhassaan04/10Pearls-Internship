const LoginElementsLocators=require('../PageElements/LoginPageElements.json')
export class LoginPageElements{


    username(username){

        cy.get(LoginElementsLocators.LoginPageLocators.username_text).type(username)
return
    }
    password(password){
        cy.get(LoginElementsLocators.LoginPageLocators.password_text).type(password) 
return
    }

    loginButton(){
        cy.get(LoginElementsLocators.LoginPageLocators.login_button).click() 
    return
    }
    verifyerror(){
        cy.get('[data-test="error"]').should('be.visible');

        // Check if the error message contains the expected text and should not exist
        cy.get('[data-test="error"]').should('contain', 'Epic sadface: Username and password do not match any user in this service');
    return;
    }
}