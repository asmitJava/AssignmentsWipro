package assignment;


import java.io.Serializable;

public class ClaimBean implements Serializable {
    private String claimantName;
    private String claimantPolicy;
    private double claimAmount;
    private String status;

    // Constructors
    public ClaimBean() {}

    // Getters and setters
    public String getClaimantName() {
        return claimantName;
    }

    public void setClaimantName(String claimantName) {
        this.claimantName = claimantName;
    }

    

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public String getClaimantPolicy() {
		return claimantPolicy;
	}

	public void setClaimantPolicy(String claimantPolicy) {
		this.claimantPolicy = claimantPolicy;
	}
}