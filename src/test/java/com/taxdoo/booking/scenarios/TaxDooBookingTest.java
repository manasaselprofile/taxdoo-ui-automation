package com.taxdoo.booking.scenarios;

import com.taxdoo.booking.pages.PersonalPage;
import com.taxdoo.booking.pages.PricePage;
import com.taxdoo.booking.pages.SuccessPage;
import com.taxdoo.booking.pages.SummaryPage;
import com.taxdoo.booking.pages.attributes.AddOn;
import org.testng.annotations.Test;

import static com.taxdoo.booking.pages.attributes.AddOn.DATEV_EXPORT;
import static com.taxdoo.booking.pages.attributes.AddOn.OSS_EXPORT;
import static com.taxdoo.booking.pages.attributes.AverageRevenue.AVERAGE_GROSS_1000;
import static com.taxdoo.booking.pages.attributes.EntityType.HYBRID;
import static com.taxdoo.booking.pages.attributes.Salutation.MRS;
import static com.taxdoo.booking.pages.attributes.Package.STARTER;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TaxDooBookingTest extends TestBase {

    private static final String EMAIL="manasa-test@taxdoo-booking.com";
    private static final String TELEPHONE="0123456789";
    private static final String COMPANY_NAME="Manasa Test";
    private static final String FIRST_NAME="Manasa";
    private static final String LAST_NAME="Vajja";
    private static final String USER_ADDRESS="Valentinskamp 70, 20355 Hamburg";
    private static final String VAT_NO="DE123456789";

    @Test
    public void testPricePage(){
        PricePage pricePage = new PricePage(driver);

        pricePage.chooseAverageRevenue(AVERAGE_GROSS_1000.getValue())
                .selectPackage(STARTER.getId())
                .selectAddOn(OSS_EXPORT.getValue())
                .selectAddOn(DATEV_EXPORT.getValue())
                .clickNext();
    }

    @Test(dependsOnMethods = {"testPricePage"})
    public void testPersonalPage(){
        PersonalPage personalPage = new PersonalPage(driver);
        personalPage
                .companyName(COMPANY_NAME)
                .salutation(MRS.getName())
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .entityType(HYBRID.getName())
                .address(USER_ADDRESS)
                .vatNo(VAT_NO)
                .email(EMAIL)
                .telephone(TELEPHONE)
                .clickNext();
    }

    @Test(dependsOnMethods = {"testPersonalPage"})
    public void testSummaryPage(){
        SummaryPage summaryPage = new SummaryPage(driver);
        assertEquals(COMPANY_NAME, summaryPage.getElementValue("Company Name"));
        assertEquals(MRS.getName()+" "+FIRST_NAME+" "+LAST_NAME, summaryPage.getElementValue("Name"));
        assertTrue(summaryPage.isElementExists("Starter"));
        assertEquals(EMAIL, summaryPage.getElementValue("Email"));
        assertEquals(TELEPHONE, summaryPage.getElementValue("Tel"));
        summaryPage.acceptTerms()
                .clickCompleteBooking();
    }

    @Test(dependsOnMethods = {"testSummaryPage"})
    public void testSuccessPage(){
        SuccessPage successPage = new SuccessPage(driver);
        assertTrue(successPage.isBookingCompleted());
    }
}
