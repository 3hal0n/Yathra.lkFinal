package com.example.yathralkfinal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.yathralkfinal.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set click listeners
        binding.logoutButton.setOnClickListener { handleLogout() }
        binding.editProfileButton.setOnClickListener { handleEditProfile() }
        binding.settingsButton.setOnClickListener { handleSettings() }

        // Load user data
        loadUserData()
    }

    private fun loadUserData() {
        // TODO: Replace with actual user data from your data source
        binding.userName.text = "Shalon Fernando"
        binding.userEmail.text = "shalonfdo@gmail.com"
        binding.userPhone.text = "+94 77 123 4567"
        binding.userLocation.text = "Negombo, Sri Lanka"
        binding.travelBio.text = "Backpacker 🌍 | Adventure Seeker | Coffee Lover"
        binding.travelStats.text = "Visited: 15 Countries 🌎 | Upcoming Trips: 3 ✈️ | Badges: 10🏅"
        binding.travelWishlist.text = "Bucket List: Japan 🇯🇵, Iceland ❄️, Patagonia 🏔️"
        binding.profileImage.setImageResource(R.drawable.profile)
    }

    private fun handleEditProfile() {
        Toast.makeText(requireContext(), "Edit Profile Clicked", Toast.LENGTH_SHORT).show()
        // TODO: Implement edit profile functionality
    }

    private fun handleSettings() {
        Toast.makeText(requireContext(), "Settings Clicked", Toast.LENGTH_SHORT).show()
        // TODO: Implement settings functionality
    }

    private fun handleLogout() {
        clearUserSession()

        val intent = Intent(requireActivity(), LoginActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        startActivity(intent)
        requireActivity().finish()

        // Add fade animation
        requireActivity().overridePendingTransition(
            android.R.anim.fade_in,
            android.R.anim.fade_out
        )
    }

    private fun clearUserSession() {
        // Example using SharedPreferences:
        val sharedPref = requireActivity().getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
        sharedPref.edit().clear().apply()
        // TODO: Clear any other session data
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}