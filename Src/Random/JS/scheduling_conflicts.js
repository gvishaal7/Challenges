/**
 * :: The Problem ::
 *
 * A speculated side-effect of repeated exposure to Vogon poetry is a
 * disassociation from the regular passage of time. As such, none of these
 * clients are particularly good at managing their calendars and frequently
 * double or even triple book themselves into overlapping classes.
 *
 * Can you assist these afflicted individuals by creating a function to find
 * all their scheduling conflicts over these upcoming classes?
 *
 */

/**
 * :: Constraints ::
 * 
 * You're welcome to create helper functions as necessary but we'd prefer you
 * limit the use of (or refrain from using) external libraries as much as
 * possible.
 *
 * The order of the result set is not important, but please return the results
 * in the following format:
 *   [
 *     {
 *       client_id: 123,
 *       client_name: "John Smith",
 *       conflicting_event_occurrence_ids: [
 *         [...],
 *         [...],
 *         ...
 *       ]
 *     },
 *     {
 *       client_id: 234,
 *       client_name: "Jane Doe",
 *       conflicting_event_occurrence_ids: [
 *         [...],
 *         [...],
 *         ...
 *       ]
 *     },
 *     ...
 *   ];
 *
 *
 * Furthermore, all elements in "conflicting_event_occurrence_ids" should be:
 *   1. A unique set. That is, it should not contain both [1, 2] and [2, 1]
 *   2. The largest set possible. If event occurrences 1, 2, and 3 all overlap,
 *      the result should contain just [1, 2, 3] and not [1, 2, 3] and [1, 2],
 *      [2, 3], [1, 3] or some combination thereof.
 *
 */


/**
 * The following are the most regular clients at The Vogon Poetry Corner and
 * are enrolled in several upcoming classes over the next couple weeks:
 */
var clients = [
  {
    id: 313,
    name: "Prophet Zarquon"
  },
  {
    id: 20091,
    name: "Svlad Cjelli"
  },
  {
    id: 33152,
    name: "Trillian"
  },
  {
    id: 33155,
    name: "Ford Prefect"
  },
  {
    id: 9931003,
    name: "Arthur Dent"
  },
];

var event_occurrences = [
  {
    id: 1029,
    service_id: 122,
    start: "Mon, 29 May 2017 11:00:00 PDT -07:00",
    end: "Mon, 29 May 2017 12:30:00 PDT -07:00",
    client_ids: [313]
  },
  {
    id: 923,
    service_id: 121,
    start: "Mon, 29 May 2017 12:00:00 PDT -07:00",
    end: "Mon, 29 May 2017 13:00:00 PDT -07:00",
    client_ids: [313, 20091, 33152]
  },
  {
    id: 1030,
    service_id: 122,
    start: "Tue, 30 May 2017 11:00:00 PDT -07:00”,
    end: "Tue, 30 May 2017 12:30:00 PDT -07:00",
    client_ids: [20091, 33152, 9931003]
  },
  {
    id: 1031,
    service_id: 122,
    start: "Wed, 31 May 2017 11:00:00 PDT -07:00",
    end: "Wed, 31 May 2017 12:30:00 PDT -07:00",
    client_ids: [313, 33152, 33155]
  },
  {
    id: 393,
    service_id: 123,
    start: "Wed, 31 May 2017 12:00:00 PDT -07:00",
    end: "Wed, 31 May 2017 12:45:00 PDT -07:00",
    client_ids: [20091, 9931003]
  },
  {
    id: 924,
    service_id: 121,
    start: "Wed, 31 May 2017 12:30:00 PDT -07:00",
    end: "Wed, 31 May 2017 13:30:00 PDT -07:00",
    client_ids: [9931003]
  },
  {
    id: 1034,
    service_id: 122,
    start: "Wed, 31 May 2017 12:30:00 PDT -07:00",
    end: "Wed, 31 May 2017 14:00:00 PDT -07:00",
    client_ids: [20091, 9931003]
  },
  {
    id: 394,
    service_id: 123,
    start: "Thu, 1 Jun 2017 12:00:00 PDT -07:00",
    end: "Thu, 1 Jun 2017 12:45:00 PDT -07:00",
    client_ids: [313, 20091]
  },
  {
    id: 1032,
    service_id: 122,
    start: "Thu, 1 Jun 2017 12:30:00 PDT -07:00",
    end: "Thu, 1 Jun 2017 14:00:00 PDT -07:00",
    client_ids: [20091]
  },
  {
    id: 8091,
    service_id: 123,
    start: "Thu, 1 Jun 2017 13:30:00 PDT -07:00",
    end: "Thu, 1 Jun 2017 14:15:00 PDT -07:00",
    client_ids: [33152, 33155, 9931003]
  },
  {
    id: 1035,
    service_id: 122,
    start: "Thu, 1 Jun 2017 14:00:00 PDT -07:00",
    end: "Thu, 1 Jun 2017 15:30:00 PDT -07:00",
    client_ids: [313, 33155, 9931003]
  },
  {
    id: 1036,
    service_id: 122,
    start: "Thu, 1 Jun 2017 15:30:00 PDT -07:00",
    end: "Thu, 1 Jun 2017 17:00:00 PDT -07:00",
    client_ids: [33152, 33155]
  },
  {
    id: 399,
    service_id: 123,
    start: "Fri, 2 Jun 2017 12:00:00 PDT -07:00",
    end: "Fri, 2 Jun 2017 12:45:00 PDT -07:00",
    client_ids: [313, 20091]
  },
  {
    id: 1033,
    service_id: 122,
    start: "Fri, 2 Jun 2017 11:00:00 PDT -07:00",
    end: "Fri, 2 Jun 2017 12:30:00 PDT -07:00",
    client_ids: [33152]
  },
  {
    id: 431,
    service_id: 123,
    start: "Fri, 2 Jun 2017 13:00:00 PDT -07:00",
    end: "Fri, 2 Jun 2017 13:45:00 PDT -07:00",
    client_ids: [33152, 9931003]
  },
  {
    id: 925,
    service_id: 121,
    start: "Fri, 2 Jun 2017 13:15:00 PDT -07:00",
    end: "Fri, 2 Jun 2017 14:15:00 PDT -07:00",
    client_ids: [33155, 9931003]
  },
  {
    id: 1037,
    service_id: 122,
    start: "Fri, 2 Jun 2017 14:00:00 PDT -07:00",
    end: "Fri, 2 Jun 2017 15:30:00 PDT -07:00",
    client_ids: [33155, 9931003]
  },

  // week 2
  {
    id: 1038,
    service_id: 122,
    start: "Mon, 5 Jun 2017 11:00:00 PDT -07:00",
    end: "Mon, 5 Jun 2017 12:30:00 PDT -07:00",
    client_ids: [33155, 9931003]
  },
  {
    id: 926,
    service_id: 121,
    start: "Mon, 5 Jun 2017 12:00:00 PDT -07:00",
    end: "Mon, 5 Jun 2017 13:00:00 PDT -07:00",
    client_ids: [313, 33152, 33155, 9931003]
  },
  {
    id: 1039,
    service_id: 122,
    start: "Tue, 6 Jun 2017 11:00:00 PDT -07:00",
    end: "Tue, 6 Jun 2017 12:30:00 PDT -07:00",
    client_ids: [313, 20091, 33152, 33155]
  },
  {
    id: 1040,
    service_id: 122,
    start: "Wed, 7 Jun 2017 11:00:00 PDT -07:00",
    end: "Wed, 7 Jun 2017 12:30:00 PDT -07:00",
    client_ids: [33152]
  },
  {
    id: 400,
    service_id: 123,
    start: "Wed, 7 Jun 2017 12:00:00 PDT -07:00",
    end: "Wed, 7 Jun 2017 12:45:00 PDT -07:00",
    client_ids: [20091, 33155, 9931003]
  },
  {
    id: 930,
    service_id: 121,
    start: "Wed, 7 Jun 2017 12:30:00 PDT -07:00",
    end: "Wed, 7 Jun 2017 13:30:00 PDT -07:00",
    client_ids: [20091, 33152, 9931003]
  },
  {
    id: 1043,
    service_id: 122,
    start: "Wed, 7 Jun 2017 12:30:00 PDT -07:00",
    end: "Wed, 7 Jun 2017 14:00:00 PDT -07:00",
    client_ids: [313, 9931003]
  },
  {
    id: 401,
    service_id: 123,
    start: "Thu, 8 Jun 2017 12:00:00 PDT -07:00",
    end: "Thu, 8 Jun 2017 12:45:00 PDT -07:00",
    client_ids: [313, 33152]
  },
  {
    id: 1041,
    service_id: 122,
    start: "Thu, 8 Jun 2017 12:30:00 PDT -07:00",
    end: "Thu, 8 Jun 2017 14:00:00 PDT -07:00",
    client_ids: [313, 33155]
  },
  {
    id: 8092,
    service_id: 123,
    start: "Thu, 8 Jun 2017 13:30:00 PDT -07:00",
    end: "Thu, 8 Jun 2017 14:15:00 PDT -07:00",
    client_ids: [20091, 9931003]
  },
  {
    id: 1044,
    service_id: 122,
    start: "Thu, 8 Jun 2017 14:00:00 PDT -07:00",
    end: "Thu, 8 Jun 2017 15:30:00 PDT -07:00",
    client_ids: [33152, 9931003]
  },
  {
    id: 1045,
    service_id: 122,
    start: "Thu, 8 Jun 2017 15:30:00 PDT -07:00",
    end: "Thu, 8 Jun 2017 17:00:00 PDT -07:00",
    client_ids: []
  },
  {
    id: 1042,
    service_id: 122,
    start: "Fri, 9 Jun 2017 11:00:00 PDT -07:00",
    end: "Fri, 9 Jun 2017 12:30:00 PDT -07:00",
    client_ids: [20091, 33155]
  },
  {
    id: 402,
    service_id: 123,
    start: "Fri, 9 Jun 2017 12:00:00 PDT -07:00",
    end: "Fri, 9 Jun 2017 12:45:00 PDT -07:00",
    client_ids: [33155]
  },
  {
    id: 432,
    service_id: 123,
    start: "Fri, 9 Jun 2017 13:00:00 PDT -07:00",
    end: "Fri, 9 Jun 2017 13:45:00 PDT -07:00",
    client_ids: [33152, 33155]
  },
  {
    id: 931,
    service_id: 121,
    start: "Fri, 9 Jun 2017 13:15:00 PDT -07:00",
    end: "Fri, 9 Jun 2017 14:15:00 PDT -07:00",
    client_ids: [20091, 9931003]
  },
  {
    id: 1046,
    service_id: 122,
    start: "Fri, 9 Jun 2017 14:00:00 PDT -07:00",
    end: "Fri, 9 Jun 2017 15:30:00 PDT -07:00",
    client_ids: [33152, 33155, 9931003]
  }
];

var findSchedulingConflicts = function(clients, event_occurrences) {
	var conflicts = [];
	// Solution goes here!
	// ...

	var upd_evt_occ = update_dates();
	var new_clt_det = get_upd_clt_det(upd_evt_occ);
	conflicts = get_conflicts(new_clt_det);
	
	return conflicts;
}

//function to convert the given date format into milliseconds
function update_dates() {
	var event_occ_size = event_occurrences.length;
	for(var index=0;index<event_occ_size;index++) {
		var curr_event = event_occurrences[index];
		var start_date = curr_event["start"];
		start_date = start_date.slice(0,start_date.length-11);
		var end_date = curr_event["end"];
		end_date = end_date.slice(0,end_date.length-11);

		start_date = new Date(start_date);
		end_date = new Date(end_date);

		curr_event["start"] = start_date.getTime();
		curr_event["end"] = end_date.getTime();
	}

	return event_occurrences;
	/*
	format of event_occurrences:
	event_occurrences = {
		id:
		service_id:
		start: <time in milliseconds>
		end: <time in milliseconds>
		client_ids: []
	};
	*/

}

//function that solves the conflicting events
//flow: events -> clients belonging to that event
function get_upd_clt_det(evt_occ) {
	var upd_clt_det = {};
	var evt_occ_size = evt_occ.length;
	for(var event_index=0;event_index<evt_occ_size;event_index++) {
		var curr_evt = evt_occ[event_index];
		var curr_evt_id = curr_evt["id"];
		var curr_evt_clts = curr_evt["client_ids"];
		var start = curr_evt["start"];
		var end = curr_evt["end"];
		//reading client one-by-one who are enrolled for the event
		for(var index_1=0;index_1<curr_evt_clts.length;index_1++) {
			var curr_clt = curr_evt_clts[index_1]; //current client
			var clt_keys = Object.keys(upd_clt_det); //upd_clt_det is an object that links a client to all the events they have enrolled in
			/*
			format of upd_clt_det:
			upd_clt_det = {
				<client id> : [
				[<event detail array>],[<client name>],[<enrolled events>]
				]
			};
			
			for every client it creates an array of arrays
			<event detail array> conatins 3 elements, <start date>, <end date> and <an array of overlapping events between the start and the end dates>
			so for every unqiue start and end date intervals there is an array as of above
			
			<enrolled events> is an array containing all the events the current client has enrolled in
			*/
			curr_clt = curr_clt.toString();
			if(clt_keys.indexOf(curr_clt) == -1) {
				var temp_events = [];
				temp_events.push(curr_evt_id);
				var temp_array = [];
				temp_array.push(start);
				temp_array.push(end);
				temp_array.push(temp_events);
				var all_events = [];
				all_events.push(curr_evt_id);
				var events_array = [];
				events_array.push(temp_array);
				var clt_det_array = [];
				clt_det_array.push(events_array);
				var clt_name = get_clt_name(curr_clt);
				clt_det_array.push(clt_name);
				clt_det_array.push(all_events);
				upd_clt_det[curr_clt] = clt_det_array; //creates a new key-value pair element in upd_cld_det for every new client encountered
			} 
			else {
				var curr_client_events = upd_clt_det[curr_clt]
				var events_array = curr_client_events[0];
				var events_array_size = events_array.length;
				for(var event=0;event<events_array_size;event++) {
					var current_event = events_array[event];
					var curr_evt_start = current_event[0];
					var curr_evt_end = current_event[1];
					var conf_events = current_event[2];
					/*
					
						s# denotes the current event (index_event)'s start date
						e# denotes the current event (index_event)'s end date
						s* denotes the client's current event (event)'s start date
						e* denotes the client's current event (event)'s start date
					
					*/
					if(curr_evt_end >= start && curr_evt_end <= end) {  //condition : s* s# e* e#
						if(all_events.indexOf(curr_evt_id) == -1) {
							conf_events.push(curr_evt_id);	
							all_events.push(curr_evt_id);
						}
						current_event[1] = end;
					}
					else if(curr_evt_start >= start && curr_evt_start <= end) { //condition: s# s* e# e*
						if(all_events.indexOf(curr_evt_id) == -1) {
							conf_events.push(curr_evt_id);
							all_events.push(curr_evt_id);
						}
						current_event[0] = start;
					}
					else if(curr_evt_start >= start && curr_evt_end <= end) { //condition: s# s* e* e#
						if(all_events.indexOf(curr_evt_id) == -1) {
							conf_events.push(curr_evt_id);
							all_events.push(curr_evt_id);
						}
						current_event[0] = start;
						current_event[1] = end;
					}
					else if(curr_evt <= start && curr_evt_end >= end) { //condition: s* s# e# e*
						if(all_events.indexOf(curr_evt_id) == -1) {
							conf_events.push(curr_evt_id);
							all_events.push(curr_evt_id);
						}
					}
					else { //condition: s* e* s# e# (or) s# e# s* e* - non-conflicting events
						var temp_array = [];
						temp_array.push(start);
						temp_array.push(end);
						var event_temp_array = [];
						event_temp_array.push(curr_evt_id);
						temp_array.push(event_temp_array);
						events_array.push(temp_array);
					}
					/*
						"all_events.indexOf(curr_evt_id) == -1" utilizes the transitivity propery:
						if a is in conflict with b and b is in conflict with c then c is in conflict with a
						and also removes duplicates ([a,b] and [b,a] is considered same)
					*/
				}			
			}  
		}	
	}
	return upd_clt_det;
}

//function to retrieve the name of the client
function get_clt_name(clt) {
	var client_size = clients.length;
	var clt_name = "";
	for(var index=0;index<client_size;index++) {
		var curr_client = clients[index];
		if(curr_client["id"] == clt) {
			clt_name = curr_client["name"];
		}
	}
	return clt_name;
}

//final function to get the output in the desired format
function get_conflicts(clt_det) {
	var conflicts = [];
	var clt_keys = Object.keys(clt_det);
	for(var index=0;index<clt_keys.length;index++) {
		var current_client = clt_det[clt_keys[index]];
		var clt_object = { 	
				client_id: clt_keys[index],
				client_name:current_client[1]
				}
		var current_client_events = current_client[0];
		var conf_events = [];
		for(var index_client=0;index_client<current_client_events.length;index_client++) {
			var events = current_client_events[index_client][2];
			if(events.length > 1) 	{ //sometimes [<enrolled events>] might contain only 1 non-conflicting element
				conf_events.push(events);
			}
		}
		clt_object["conflicting_event_occurrence_ids"] = conf_events;
		if(conf_events.length >=1) {
			conflicts.push(clt_object);
		} 
	}
	return conflicts;
}
