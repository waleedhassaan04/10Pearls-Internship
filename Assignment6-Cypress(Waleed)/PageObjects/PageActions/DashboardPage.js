const DasboardElementsLocators=require('../PageElements/DashboardPageElements.json')
export class DashboardPageElements{
    item='[data-test="item-4-title-link"] > [data-test="inventory-item-name"]'
    title='[data-test="title"]'
    select_item(){
        cy.get(DasboardElementsLocators.DashboardPageLocators.item).click();
        return

    }
    header(){
        cy.get(DasboardElementsLocators.DashboardPageLocators.title).contains('Products')
        return
    }

}