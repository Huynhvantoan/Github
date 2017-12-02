package com.toanit.core.imageload

import android.net.Uri

import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.controller.ControllerListener
import com.facebook.drawee.generic.GenericDraweeHierarchy
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder
import com.facebook.drawee.interfaces.DraweeController
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.common.ImageDecodeOptions
import com.facebook.imagepipeline.common.ResizeOptions
import com.facebook.imagepipeline.request.ImageRequest
import com.facebook.imagepipeline.request.ImageRequestBuilder
import com.toan_itc.data.utils.DensityUtil
import com.toan_itc.data.utils.Preconditions
import com.toanit.core.utils.Preconditions


class FrescoImageLoader : ImageLoaderListener {
    override fun loadImage(url: String, simpleDraweeView: SimpleDraweeView) {
        Preconditions.checkNotNull(simpleDraweeView, "SimpleDraweeView not null!")
        simpleDraweeView.setImageURI(Uri.parse(url))
    }

    override fun loadController(url: String, simpleDraweeView: SimpleDraweeView, width: Int, height: Int, controllerListener: ControllerListener<*>?) {
        Preconditions.checkNotNull(simpleDraweeView, "simpleDraweeView not null!")
        Preconditions.checkNotNull(controllerListener, "controllerListener not null!")
        val request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
                .setLocalThumbnailPreviewsEnabled(true)
                .setCacheChoice(ImageRequest.CacheChoice.DEFAULT)
                .setProgressiveRenderingEnabled(true)
                .setImageDecodeOptions(ImageDecodeOptions.defaults())
                .setResizeOptions(ResizeOptions(RDimen.dip(width), RDimen.dip(height)))
                .build()
        val controller = Fresco.newDraweeControllerBuilder()
                .setTapToRetryEnabled(true)
                .setAutoPlayAnimations(true)
                .setOldController(simpleDraweeView.controller)
                .setImageRequest(request)
                .setControllerListener(controllerListener)
                .build()
        simpleDraweeView.controller = controller
    }

    override fun loadController(url: String, simpleDraweeView: SimpleDraweeView, width: Int, height: Int) {
        Preconditions.checkNotNull(simpleDraweeView, "simpleDraweeView not null!")
        val request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
                .setLocalThumbnailPreviewsEnabled(true)
                .setCacheChoice(ImageRequest.CacheChoice.DEFAULT)
                .setProgressiveRenderingEnabled(true)
                .setImageDecodeOptions(ImageDecodeOptions.defaults())
                .setResizeOptions(ResizeOptions(dip(width), dip(height)))
                .build()
        val controller = Fresco.newDraweeControllerBuilder()
                .setTapToRetryEnabled(true)
                .setAutoPlayAnimations(true)
                .setOldController(simpleDraweeView.controller)
                .setImageRequest(request)
                .build()
        simpleDraweeView.controller = controller
    }

    override fun loadHierarchy(url: String, simpleDraweeView: SimpleDraweeView) {
        Preconditions.checkNotNull(simpleDraweeView, "simpleDraweeView not null!")
        val hierarchy = GenericDraweeHierarchyBuilder(null)
                .setFadeDuration(300)
                .setPlaceholderImage(null)
                .setBackground(null)
                .setOverlays(null)
                .build()
        simpleDraweeView.hierarchy = hierarchy
    }
}
