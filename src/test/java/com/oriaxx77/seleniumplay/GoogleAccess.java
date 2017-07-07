package com.oriaxx77.seleniumplay;


public class GoogleAccess
{
    private String url;
    private String search;

    public GoogleAccess(String url, String search)
    {
        this.url = url;
        this.search = search;
    }

    public String getUrl()
    {
        return url;
    }

    public String getSearch()
    {
        return search;
    }

    @Override
    public String toString() {
        return "GoogleAccess{" +
                "url='" + url + '\'' +
                ", search='" + search + '\'' +
                '}';
    }
}
