# Flickr Kitten

This application is pulling data using the Flickr API using OkHttp, AsyncTask and EventBus.

## MainActivity

![](https://github.com/ssmobile/flicker-kitten-app/blob/master/screenshots/MainActivity.png?raw=true)

The Main activity is subscribed to the event being posted in the `onPostExecute()` method of the AsyncTask.
Once the data is pulled from the API and sent posted to the Main Activity, a RecyclerView is created with the API's information and the list is populated.

## ImageAdapter

On a long click, the user is prompted with a Dialog. 

![](https://github.com/ssmobile/flicker-kitten-app/blob/master/screenshots/DialogOptions.png?raw=true)

If the user taps on __"Full Image"__ they are sent to the FullScreenActivity.
The drawable of that specific list item is serialized and put into a Bundle.
The drawable is then de-serialized into a Bitmap and set onto an ImageView.

![](https://github.com/ssmobile/flicker-kitten-app/blob/master/screenshots/FullScreenActivity.png?raw=true)

If the user taps on __"Thumbnail"__, a new dialog opens. A layout to hold the image is inflated and the image is set onto an ImageView of that layout. Thus, the user can see a thumbnail of the image they selected.

![](https://github.com/ssmobile/flicker-kitten-app/blob/master/screenshots/DialogThumbnail.png)

