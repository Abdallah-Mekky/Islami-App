package com.task1.islami.ui.fragments

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.task1.islami.R
import com.task1.islami.api.ApiManager
import com.task1.islami.model.RadiosItem
import kotlinx.coroutines.launch
import java.lang.Exception

class RadioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.radio_fragment, container, false)
    }

    lateinit var channelName: TextView
    lateinit var playButton: ImageView
    lateinit var forwardButton: ImageView
    lateinit var backButton: ImageView
    lateinit var audios: MutableList<RadiosItem>
    lateinit var progress: ProgressBar
    var mediaPlayer = MediaPlayer()
    var isPlaying = false
    var postion = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        getAudiosFromApi()
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer.stop()
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer.stop()
    }

    private fun getAudiosFromApi() {

        lifecycleScope.launch {

            try {
                audios = ApiManager.getApis().getAudios().radios as MutableList<RadiosItem>

                playButton()
                nextButton()
                backButton()

            } catch (ex: Exception) {

                Toast.makeText(requireContext(),ex.localizedMessage,Toast.LENGTH_LONG)
            }
        }
    }

    fun initMediaPlyer(pos: Int) {

        val url = audios[pos].uRL!!
        channelName.text = audios[postion].name
        mediaPlayer = MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(url)
            prepareAsync() // might take long! (for buffering, etc)

        }
        mediaPlayer.setOnPreparedListener {
            it.start()
            progress.isVisible = false
            Toast.makeText(requireContext(), "now open", Toast.LENGTH_LONG).show()
        }

    }

    fun playButton() {

        playButton.setOnClickListener {

            if (!isPlaying) {
                isPlaying = true
                progress.isVisible = true

                initMediaPlyer(postion)
            } else {
                isPlaying = false
                progress.isVisible = false
                mediaPlayer.stop()
            }
        }
    }

    fun nextButton() {

        forwardButton.setOnClickListener {

            if (isPlaying) {

                mediaPlayer.stop()
                postion++
                initMediaPlyer(postion)
            }
        }

    }

    fun backButton() {

        backButton.setOnClickListener {

            if (isPlaying && postion > 0) {

                mediaPlayer.stop()
                postion--
                initMediaPlyer(postion)
            }
        }
    }

    private fun initViews() {

        channelName = requireView().findViewById(R.id.holy_Quran_Radio)
        playButton = requireView().findViewById(R.id.play)
        forwardButton = requireView().findViewById(R.id.next)
        backButton = requireView().findViewById(R.id.previous)
        progress = requireView().findViewById(R.id.progress)

    }
}