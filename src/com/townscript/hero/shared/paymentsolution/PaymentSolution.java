package com.townscript.hero.shared.paymentsolution;


public enum PaymentSolution {

	PAYUMONEY{

		@Override
		public Integer getIndex() {
			return 0;
		}

		@Override
		public String getPaymentSolutionSource() {
			return "PAYUMONEY";
		}
		
	},
	PAYTM{

		@Override
		public Integer getIndex() {
			return 1;
		}

		@Override
		public String getPaymentSolutionSource() {
			return "PAYTM";
		}
	};
	
	public abstract Integer getIndex();

	
	public abstract String getPaymentSolutionSource();


	public static PaymentSolution getPaymentSolutionSource(Integer index) {
		
		PaymentSolution paymentSolution = null;
		
		for(PaymentSolution type : PaymentSolution.values()) {
			 if(type.getIndex()==index){
				 paymentSolution = type;
                 break;
         }
		}
		return paymentSolution;
	}
}
