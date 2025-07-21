package br.com.logos.telinhaquente.model;

public class RespostaApi {
    private String Response;
    private String Error;

    public String getResponse() { return Response; }
    public void setResponse(String response) { this.Response = response; }

    public String getError() { return Error; }
    public void setError(String error) { this.Error = error; }
}
