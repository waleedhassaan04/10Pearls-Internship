const { defineConfig } = require("cypress");

module.exports = defineConfig({
  e2e: {
   watchForFileChange: false, // Corrected syntax for disabling file change watching
     responseTimeout :60000,// Assigning responseTimeout to config object
      screenshotOnRunFailure:false, // Assigning screenshotOnRunFailure to config object
     video : false,
     reporter:"mochawesome",
     chromeWebSecurity:false,
          reporterOptions:{
code:false
     },
   baseUrl:'https://www.saucedemo.com',
    setupNodeEvents(on, config) {
     
      
    
    },
  },

  component: {
    devServer: {
      framework: "next",
      bundler: "webpack",
    },
  },
});
