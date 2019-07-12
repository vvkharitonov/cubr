package hellocucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;

class IsItFriday {
    static String isItFriday(String today) {
        return "Friday".equals(today) ? "TGIF" : "Nope";
    }
}

public class Stepdefs {
    private String today;
    //private String file_type;
    private String actualAnswer;
    // private String[] headers;
    // String[] tradeHeaders = {"type","base_asset","base_amount","counter_asset","counter_amount","fee_asset","fee_amount","rebate_asset","rebate_amount","rate","base_usd_rate","base_xbt_rate","counter_usd_rate","counter_xbt_rate","tx_ts","order_ts","exchange_name","exchange_order_id","exchange_tx_id","client_order_id","client_tx_id","initial_margin","client_tags","system_tags","comment"};
    // String[] transferHeaders =

    void Stepdefs() {
        //headers = new String[];
    }

//
//    @Given("^file of \"([^\"]*)\"$")
//    public void file_type(String trade_type) {
//      //  this.file_type = trade_type;
//      //  headers = Arrays.copyOf(tradeHeaders,tradeHeaders.length);
//    }


    @Given("^today is \"([^\"]*)\"$")
    public void today_is(String today) {
        this.today = today;
    }

    @When("^I ask whether it's Friday yet$")
    public void i_ask_whether_it_s_Friday_yet() {
        this.actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("^I should be told \"([^\"]*)\"$")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }
}