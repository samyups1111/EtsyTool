# EtsyTool

## Intro:

WIP. An app used to search for Etsy shops using the Etsy API. Users can click on the shops to see all the listings available. 

## Architecture:

* MVVM Architecture:
  * [Model](https://github.com/samyups1111/EtsyTool/tree/main/app/src/main/java/com/sammydj/etsytool/model)
  * [View](https://github.com/samyups1111/EtsyTool/tree/main/app/src/main/java/com/sammydj/etsytool/view)
  * ViewModel   
  
## Libraries

* [Room Persistence Library](https://github.com/samyups1111/EtsyTool/tree/main/app/src/main/java/com/sammydj/etsytool/database)
* [Retrofit Library](https://github.com/samyups1111/EtsyTool/tree/main/app/src/main/java/com/sammydj/etsytool/networking)
* [Moshi Library](https://github.com/samyups1111/EtsyTool/blob/main/app/src/main/java/com/sammydj/etsytool/networking/Retrofit.kt)
* Coroutine
* [Picasso](https://github.com/samyups1111/EtsyTool/blob/main/app/src/main/java/com/sammydj/etsytool/util/BindPictureToImageView.kt)

## Other:
* [Infinite scroll/Pagination](https://github.com/samyups1111/EtsyTool/blob/main/app/src/main/java/com/sammydj/etsytool/view/mainactivity/recyclerview/RecyclerViewPaginator.kt)
* [Nested RecyclerViews](https://github.com/samyups1111/EtsyTool/blob/main/app/src/main/java/com/sammydj/etsytool/view/shopactivity/ListingsViewHolder.kt)
