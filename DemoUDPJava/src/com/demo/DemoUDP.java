package com.demo;

import com.ibm.broker.plugin.MbPolicy;
import com.ibm.broker.plugin.MbException;

public class DemoUDP {
	public static String getPolicyProperty(String policyName, String propertyName) {
		String resultPropertyValue = null;
		try {
			MbPolicy myPol = MbPolicy.getPolicy("UserDefined", policyName);
			if (myPol != null) {
				resultPropertyValue = myPol.getPropertyValueAsString(propertyName);
				if (resultPropertyValue == null) {
					System.out.println("Unable to find property '" +propertyName+ "' in UserDefined policy with name '" +policyName+ "'");
				} else {
					System.out.println("Found property '" +propertyName+ "' with value '" +resultPropertyValue+ "' in UserDefined policy with name '" +policyName+ "'");
				}
			} else {
				System.out.println("Unable to find UserDefined policy with name '" +policyName+ "'");
			}
		} catch (MbException mbe) {
			System.out.println("Exception caught trying to find UserDefined policy with name '" +policyName+ "'. Execption details: '" +mbe.toString()+ "'");
		}
		return resultPropertyValue;
	}
}
