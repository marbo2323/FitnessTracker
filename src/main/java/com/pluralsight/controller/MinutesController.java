package com.pluralsight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;
import com.pluralsight.service.ExerciseService;

@Controller
public class MinutesController {
	
	@Autowired
	ExerciseService exerciseService;
	
	@RequestMapping(value="/addMinutes")
	public String addMinutes(@ModelAttribute("Exercise") Exercise exercise) {
		
		System.out.println("exercise: " + exercise.getMinutes());
		System.out.println("exercise activity: " + exercise.getActivity());
		
		return "addMinutes";
	}
	
	@RequestMapping(value = "/activities", method = RequestMethod.GET)
	public @ResponseBody List<Activity> findAllActivities(){
		List<Activity> activities = exerciseService.findAllActivities();
		return activities;
	} 
	
	
	/*
	@RequestMapping(value="/addMoreMinutes")
	public String addMoreMinutes(@ModelAttribute("Exercise") Exercise exercise) {
		
		System.out.println("exercise from add more minutes : " + exercise.getMinutes());
		
		return "addMinutes";
	}
	*/

}
