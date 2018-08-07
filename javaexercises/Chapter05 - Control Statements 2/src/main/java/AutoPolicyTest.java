/**
 * Created by geoffrey on 2/8/18.
 */
public class AutoPolicyTest {
    public static void main(String[] args){
        AutoPolicy autoPolicy1 = new AutoPolicy(11111, "Toyota Camri", "NY");
        AutoPolicy autoPolicy2 = new AutoPolicy(22222, "Ford Focus", "GA");

        policyInNoFaultState(autoPolicy1);
        policyInNoFaultState(autoPolicy2);


    }

    private static void policyInNoFaultState(AutoPolicy policy) {
        System.out.println("The Auto Policy:");
        System.out.printf("Account #: %d, Model: %s, State : %s %s a No Fault state.\n",
                policy.getAccountNumber(), policy.getMakeAndModel(), policy.getState(),
                policy.isNoFaultState()? "is": "is not");
    }
}
