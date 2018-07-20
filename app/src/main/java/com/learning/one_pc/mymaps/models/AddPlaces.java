package com.learning.one_pc.mymaps.models;

import android.util.Log;
/*
public class AddPlaces extends AsyncTask<String, String, PlacesList> {

        protected PlacesList doInBackground(String... arg0) {
            try
                Log.v(LOG_KEY, "Adding Place...");
                GenericUrl reqUrl = new GenericUrl(PLACE_ADD_URL);
                reqUrl.put("key", API_KEY);
                reqUrl.put("sensor", "false");
                Log.v(LOG_KEY, "Adding Place...");
                // reqUrl.put("Host:", "maps.googleapis.com");
                /*
                 * reqUrl.put( "Host: maps.googleapis.com",
                 * "{\"location\":{\"lat\":" + Double.toString(lat) +
                 * ",\"lng\":" + Double.toString(lon) +
                 * "},\"accuracy\":50.0,\"name\":\"event\",\"types\":[\"school\"],\"language\":\"en\"}"
                 * );
                 */
/*
                reqUrl.put(
                        "Host: maps.googleapis.com",
                        "{\"location\":{\"lat\":1.347988,\"lng\":103.936179},\"accuracy\":50.0,\"name\":\"events\",\"types\":[\"school\"],\"language\":\"en\"}");
                Log.v(LOG_KEY, "Requested URL= " + reqUrl);

                HttpRequestFactory httpRequestFactory = createRequestFactory(HTTP_TRANSPORT);
                HttpRequest request = httpRequestFactory
                        .buildGetRequest(reqUrl);

                Log.v(LOG_KEY, request.execute().parseAsString());
                place = request.execute().parseAs(PlacesList.class);

                Log.v(LOG_KEY, "STATUS = " + place.status);
                Log.v(LOG_KEY, "Place Added is = " + place);
                return place;

            } catch (HttpResponseException e) {
                // Log.v(LOG_KEY, e.getResponse().parseAsString());
                Log.v(LOG_KEY, e.getMessage());
                try {
                    throw e;
                } catch (HttpResponseException e1) {
                    e1.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return place;
        }
    }
    EDITTED


}
*/