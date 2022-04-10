package com.huaqiao.cmd;

public class IOBook {
	private int id;
	private String lendtime;
	private String returntime;
	private String state;
	private String readername;
	private int readerid;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the lendtime
	 */
	public String getLendtime() {
		return lendtime;
	}
	/**
	 * @param lendtime the lendtime to set
	 */
	public void setLendtime(String lendtime) {
		this.lendtime = lendtime;
	}
	/**
	 * @return the returntime
	 */
	public String getReturntime() {
		return returntime;
	}
	/**
	 * @param returntime the returntime to set
	 */
	public void setReturntime(String returntime) {
		this.returntime = returntime;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the readername
	 */
	public String getReadername() {
		return readername;
	}
	/**
	 * @param readername the readername to set
	 */
	public void setReadername(String readername) {
		this.readername = readername;
	}
	/**
	 * @return the readerid
	 */
	public int getReaderid() {
		return readerid;
	}
	/**
	 * @param readerid the readerid to set
	 */
	public void setReaderid(int readerid) {
		this.readerid = readerid;
	}
	@Override
	public String toString() {
		return "IOBook [id=" + id + ", lendtime=" + lendtime + ", returntime=" + returntime + ", state=" + state
				+ ", readername=" + readername + ", readerid=" + readerid + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((lendtime == null) ? 0 : lendtime.hashCode());
		result = prime * result + readerid;
		result = prime * result + ((readername == null) ? 0 : readername.hashCode());
		result = prime * result + ((returntime == null) ? 0 : returntime.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		IOBook other = (IOBook) obj;
		if (id != other.id)
			return false;
		if (lendtime == null) {
			if (other.lendtime != null)
				return false;
		} else if (!lendtime.equals(other.lendtime))
			return false;
		if (readerid != other.readerid)
			return false;
		if (readername == null) {
			if (other.readername != null)
				return false;
		} else if (!readername.equals(other.readername))
			return false;
		if (returntime == null) {
			if (other.returntime != null)
				return false;
		} else if (!returntime.equals(other.returntime))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
}
