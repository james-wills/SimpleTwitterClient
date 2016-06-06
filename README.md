# Project 3 - *SimpleTwitterClient*

**SimpleTwitterClient** is an android app that allows a user to view home and mentions timelines, view user profiles with user timelines, as well as compose and post a new tweet. The app utilizes [Twitter REST API](https://dev.twitter.com/rest/public).

Time spent: **40** hours spent in total

## User Stories

The following **required** functionality is completed:

* [x]	User can **sign in to Twitter** using OAuth login
* [x] User can **switch between Timeline and Mention views using tabs**
  * [x] User is displayed the username, name, and body for each tweet
  * [x] User is displayed the [relative timestamp](https://gist.github.com/nesquena/f786232f5ef72f6e10a7) for each tweet "8m", "7h"
  * [x] User can **pull down to refresh tweets** in either timeline
  * [x] User can view more tweets as they scroll with [infinite pagination](http://guides.codepath.com/android/Endless-Scrolling-with-AdapterViews-and-RecyclerView). Number of tweets is unlimited.
* [x] User can navigate to **view their own profile**
  * [x] User can see picture, tagline, # of followers, # of following, and tweets on their profile.
* [x] User can **click on the profile image** in any tweet to see **another user's** profile.
 * [x] User can see picture, tagline, # of followers, # of following, and tweets of clicked user.
 * [x] Profile view includes that user's timeline
* [x] User can **compose and post a new tweet**
  * [x] User can click a “Compose” icon in the Action Bar on the top right
  * [x] User can then enter a new tweet and post this to twitter
  * [x] User is taken back to home timeline with **new tweet visible** in timeline
  * [x] User can **see a counter with total number of characters left for tweet** on compose tweet page
* [x] When a network request is sent, user sees an [indeterminate progress indicator](http://guides.codepath.com/android/Handling-ProgressBars#progress-within-actionbar)
* [ ] User can **open the twitter app offline and see last loaded tweets**. Persisted in SQLite tweets are refreshed on every application launch. While "live data" is displayed when app can get it from Twitter API, it is also saved for use in an offline mode.

The following **optional** features are implemented:

* [ ] User can **click a link within a tweet body** on tweet details view. The click will launch the web browser with relevant page opened.
* [ ] User can view following / followers list through the profile
* [ ] Implements robust error handling, [check if internet is available](http://guides.codepath.com/android/Sending-and-Managing-Network-Requests#checking-for-network-connectivity), handle error cases, network failures
* [ ] User can **"reply" to any tweet on their home timeline**
  * [ ] The user that wrote the original tweet is automatically "@" replied in compose
* [ ] User can click on a tweet to be **taken to a "detail view"** of that tweet
 * [ ] User can take favorite (and unfavorite) or retweet actions on a tweet
* [x] Improve the user interface and theme the app to feel twitter branded
* [ ] User can **search for tweets matching a particular query** and see results

The following **bonus** features are implemented:

* [ ] Used Parcelable instead of Serializable leveraging the popular [Parceler library](http://guides.codepath.com/android/Using-Parceler).
- [ ] Replaced all icon drawables and other static image assets with [vector drawables](http://guides.codepath.com/android/Drawables#vector-drawables) where appropriate. 
* [x] Apply the popular [Butterknife annotation library](http://guides.codepath.com/android/Reducing-View-Boilerplate-with-Butterknife) to reduce view boilerplate.
* [ ] User can view their direct messages (or send new ones)

The following **additional** features are implemented:

* [x] Tweet images are displayed, with different layouts for 1, 2, 3, or 4 images
  * [x] Tweet image corners are rounded w/ respect to their position to present as a cohesive element
* [x] Links, mentions and hashtags are highlighted in tweets. I did not have time to implement click handlers for them however.
* [x] Retweets are displayed properly
* [x] Coordinator layout used to create collapsing toolbars/ profile headers
* [x] Used Caligraphy library to change the font to various weights of roboto
* [x] favorites view on profile screen
## Video Walkthrough

Walkthroughs:

- [Compose character counts](http://i.imgur.com/kX7fNGT.gifv)
- [Compose and post](http://i.imgur.com/FqOLnAn.webm)
- [Timeline view](http://i.imgur.com/qjdGMfP.mp4)
- [Profile view with click through to another profile](http://i.imgur.com/iIdsjLD.webm)
- [Profile view 2](http://i.imgur.com/TR2z7bv.webm)
- [swipe to refresh](http://i.imgur.com/YZkyWMC.webm)
- [Flexible image layouts](http://i.imgur.com/lTImNKO.gifv)

GIF created with [CaptureGif](http://www.cockos.com/licecap/).

## Notes

Describe any challenges encountered while building the app.
- Keeping image corner crops consistent was difficult. The solution was to do a two part bitmap transform with Glide-transformations. First to crop the image to the view bounds, and the second to round the corners.
- Coordinator layouts are a little more complicated with ListViews in PagerLayouts.
- Parsing the tweet text for links is tricky, because the twitter api passes many types of links (url, displayurl, expandedurl, mediaurl).

## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android
- ButterKnife
- PagerSlidingTabStrip
- Caligraphy
- Glide-transformations
- PrettyTime
- ActiveAndroid

## License

    Copyright [2016] [James Wills]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
