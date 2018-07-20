package com.learning.one_pc.mymaps.models;

public class RedundantCode {
    public static void main(String[] args){

    }

    /*commit to memory. Another way of using a keylistener
        searchbar.setOnKeyListener(new TextView.OnKeyListener() {

            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                //if the event is a key-down event on the "Enter" button
                if((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
                    Toast.makeText(MapActivity.this, "key is working!", Toast.LENGTH_LONG).show();
                    geoLocate();
                    return true;
                }
                return false;
            }
        });
*/
    /*unnecessary
            oPlaceInfo = new PlaceInfo();
            try {
                Toast.makeText(MapActivity.this, "tick1", Toast.LENGTH_SHORT).show();
                oPlaceInfo.setId(place.getId());
                Toast.makeText(MapActivity.this, "tick2", Toast.LENGTH_SHORT).show();

                oPlaceInfo.setAddress(place.getAddress().toString());
                Toast.makeText(MapActivity.this, "tick3", Toast.LENGTH_SHORT).show();


                oPlaceInfo.setLatLng(place.getLatLng());
                Toast.makeText(MapActivity.this, "tick5", Toast.LENGTH_SHORT).show();

                if(place.getPhoneNumber() != null) {
                    oPlaceInfo.setPhoneNumber(place.getPhoneNumber().toString());
                    Toast.makeText(MapActivity.this, "tick6", Toast.LENGTH_SHORT).show();
                }
                if(place.getWebsiteUri() != null) {
                    oPlaceInfo.setWebsiteUri(place.getWebsiteUri());
                    Toast.makeText(MapActivity.this, "tick7", Toast.LENGTH_SHORT).show();
                }
                if(place.getAttributions() != null){
                    oPlaceInfo.setAttributions(place.getAttributions().toString());
                }

            }
            catch (NullPointerException e){
                Toast.makeText(MapActivity.this, "Error in setting info: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
             moveCam(new LatLng(place.getViewport().getCenter().latitude, place.getViewport().getCenter().longitude), DEFAULT_ZOOM, oPlaceInfo);

            */


   /* private void geoPlaceAdd(){

        AddPlaceRequest newplace = new AddPlaceRequest(
                "Gilbert Parking",
                new LatLng(0.3318315, 32.5700924),
                "Makerere Park lot 002",
                Collections.singletonList(Place.TYPE_PARKING),
                "+256 752 633239"
        );

        //adding places on map
        pGeoDataClient = Places.getGeoDataClient(this, null);
        pGeoDataClient.addPlace(newplace).addOnCompleteListener(
                new OnCompleteListener<PlaceBufferResponse>() {
                    @Override
                    public void onComplete(@NonNull Task<PlaceBufferResponse> task) {
                        if(task.isSuccessful() && task.getResult() != null){
                        PlaceBufferResponse places = task.getResult();
                        Toast.makeText(MapActivity.this, "Added place " + places.get(0).getName().toString(), Toast.LENGTH_SHORT).show();
                        places.release();}
                        else
                            Toast.makeText(MapActivity.this, "Task unsuccessful: ", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    //adding data to child
      new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String newValue = field.getText().toString();
                        if(!newValue.equals("")){
                            FirebaseUser user = mAuth.getCurrentUser();
                            String userID = user.getUid();
                            mDatabaseReference.child(userID).child("friends").child("Still my friend").setValue(newValue);
                            Toast.makeText(Registration.this, "Adding "+ newValue+" to database...", Toast.LENGTH_SHORT).show();
                            field.setText("");
                        }
                    }
                }
    */

}
