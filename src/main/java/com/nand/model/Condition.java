package com.nand.model;

/**
 * the condition part/s of the rule
 * 
 * @author Nand
 */
public class Condition {
	private long value;
	private Operation op;

	public Condition(long value, Operation op) {
		this.value = value;
		this.op = op;
	}

	public boolean applies(long num) {
		switch (this.op) {
		case EQ:
			return num == value;
		case GT:
			return num > value;
		case LT:
			return num < value;
		default:
			return false;
		}
	}

	@Override
	public String toString() {
		return "" + op + value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((op == null) ? 0 : op.hashCode());
		result = prime * result + (int) (value ^ (value >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Condition other = (Condition) obj;
		if (op != other.op)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	public enum Operation {
		GT(">"), LT("<"), EQ("=");
		private String op;

		private Operation(String op) {
			this.op = op;
		}

		public String getOp() {
			return op;
		}

		@Override
		public String toString() {
			return op;
		}

		/**
		 * get an instance of {@link Operation} using a String
		 * 
		 * @param cond
		 * @return
		 * @throws IllegalArgumentException
		 *             if the input string does not have a related {@link Operation}
		 *             value
		 */
		public static Operation fromString(String cond) {
			for (Operation tp : values())
				if (tp.getOp().equals(cond))
					return tp;
			throw new IllegalArgumentException("Condition " + cond + " not found");
		}
	}
}