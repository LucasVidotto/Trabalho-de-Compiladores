package parser;

import java.util.List;

public class ResultCriaCompiler {
	private String error;
	private String dump;
	private String result;
	private List<String> logs;
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	public String getDump() {
		return dump;
	}
	public void setDump(String dump) {
		this.dump = dump;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public List<String> getLogs() {
		return logs;
	}
	public void setLogs(List<String> logs) {
		this.logs = logs;
	}
}
