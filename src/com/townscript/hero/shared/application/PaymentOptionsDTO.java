package com.townscript.hero.shared.application;


public enum PaymentOptionsDTO {

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
	CITRUSPAY{

		@Override
		public Integer getIndex() {
			return 1;
		}

		@Override
		public String getPaymentSolutionSource() {
			return "CITRUSPAY";
		}
	},
	CCDBCARD{

		@Override
		public Integer getIndex() {
			return 2;
		}

		@Override
		public String getPaymentSolutionSource() {
			return "CCDBCARD";
		}
	};
	
	public abstract Integer getIndex();

	
	public abstract String getPaymentSolutionSource();


	public static PaymentOptionsDTO getPaymentSolutionSource(Integer index) {
		
		PaymentOptionsDTO paymentSolution = null;
		
		for(PaymentOptionsDTO type : PaymentOptionsDTO.values()) {
			 if(type.getIndex()==index){
				 paymentSolution = type;
                 break;
         }
		}
		return paymentSolution;
	}
}
