package com.hugothomaz.rotafrete.screen.freight.steps

import android.Manifest
import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.hugothomaz.rotafrete.R
import com.hugothomaz.rotafrete.databinding.StepPointFragmentBinding
import com.hugothomaz.rotafrete.screen.freight.FreightViewModel
import com.tbruyelle.rxpermissions2.RxPermissions
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FragmentPoint : Fragment(R.layout.step_point_fragment), OnMapReadyCallback {
    private val TAG = "TesteMapa"

    private val viewModel by sharedViewModel<FreightViewModel>()
    private lateinit var bind : StepPointFragmentBinding

    private var googleMaps: GoogleMap? = null
    private var fusedLocationProviderClient: FusedLocationProviderClient? = null
    private val ZOOM_DEFAULT = 15f

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = StepPointFragmentBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()

        if (isServiceOk()) {
            checkSalePermissions()
        }
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        this.googleMaps = googleMap
    }

    private fun bindViewModel(){
        bind.viewModel = viewModel
    }

    private fun getDeviceLocation() {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireActivity())

        try {
            if (fusedLocationProviderClient != null) {
                val taskLocation = fusedLocationProviderClient!!.lastLocation
                taskLocation.addOnCompleteListener {
                    if (taskLocation.isSuccessful) {
                        val location = taskLocation.getResult() as Location
                        moveCamera(LatLng(location.latitude, location.longitude), ZOOM_DEFAULT)
                    }
                }
            }

        } catch (e: SecurityException) {

        }
    }

    private fun moveCamera(latLng: LatLng, zoom: Float) {
        googleMaps?.apply {
            moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom))
            isMyLocationEnabled = true
        }
    }

    private fun initMap() {
        val supportMapFragment =
            childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        supportMapFragment.getMapAsync(this)
        getDeviceLocation()
    }


    private fun isServiceOk(): Boolean {
        Log.d(TAG, "isServiceOk verifica estado da conexão do servico do google")

        val available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(requireActivity())

        if (available == ConnectionResult.SUCCESS) {
            Log.d(TAG, "isServiceOk verifica - Success")
            return true
        } else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
            Log.d(TAG, "isServiceOk verifica - Error")
            return false
        } else {
            Log.d(TAG, "isServiceOk verifica - Você não pode fazer solicitação de mapa")
            return false
        }
    }

    @SuppressLint("CheckResult")
    fun checkSalePermissions() {
        RxPermissions(requireActivity())
            .requestEach(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
            .subscribe { permission ->
                when {
                    permission.granted -> {
                        //Trabalha com mapa
                        initMap()
                    }
                    permission.shouldShowRequestPermissionRationale -> {
                        //Mostra dialog
                    }
                    else -> {
                        showDetailSettings(/*R.string.error_permission_camera*/)
                    }
                }
            }
    }

    private fun showDetailSettings(/*@StringRes msg: Int*/) {
        Log.d(TAG, "Abrir settings detail para dar as permissões")
        /* Snackbar
             .make(
                 *//*getViewDataBinding().root,
                getString(msg),
                Snackbar.LENGTH_INDEFINITE*//*
            )
            .setAction(getString(R.string.lable_button_request_permission)) {
                startApplicationSettings()
            }
            .show()*/
    }

}