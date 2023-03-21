package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ComunaModel {
	 @JsonProperty("comuna")
	    private Comuna comuna;
	 
	 public static class Comuna {
	        @JsonProperty("name")
	        private String name;
	 }
//
//
//	    public static class Comuna {
//	        @JsonProperty("name")
//	        private String name;
//
//	        @JsonProperty("code")
//	        private String code;
//
//	        @JsonProperty("contained_in")
//	        private ContainedIn containedIn;
//
//
//	        public static class ContainedIn {
//	            @JsonProperty("provincia")
//	            private Provincia provincia;
//
//
//
//	            public static class Provincia {
//	                @JsonProperty("code")
//	                private String code;
//
//	            }
//	        }
//	    }
	}