/**
 * Creates pre-filled demo store
 */

print('dump start');

db.stores.update(
    { "_id": "demo" },
    {
        "_id": "demo",
        "lastSeen": new Date(),
        "storename": "Blackhawk Alterations",
        "addressstreet": "2201 Van Ness Ave",
        "addresscity": "San Francisco",
        "addressstate": "CA",
        "addresspostalcode": "94109",
        "addresscountry": "US",
        "openings": [
            {
                "from_date": new Date("2017-01-01"),
                "to_date": new Date("2018-12-31"),
                "priority": 1,
                "weekday_id": 2,
                "start": 9 * 3600 + 0 * 60 + 0,
                "end": 17 * 3600 + 0 * 60 + 0,
                "pause_start": 12 * 3600 + 0 * 60 + 0,
                "pause_end": 13 * 3600 + 0 * 60 + 0,
            },
            {
                "from_date": new Date("2017-01-01"),
                "to_date": new Date("2018-12-31"),
                "priority": 1,
                "weekday_id": 3,
                "start": 9 * 3600 + 0 * 60 + 0,
                "end": 17 * 3600 + 0 * 60 + 0,
                "pause_start": 12 * 3600 + 0 * 60 + 0,
                "pause_end": 13 * 3600 + 0 * 60 + 0,
            },
            {
                "from_date": new Date("2017-01-01"),
                "to_date": new Date("2018-12-31"),
                "priority": 1,
                "weekday_id": 4,
                "start": 9 * 3600 + 0 * 60 + 0,
                "end": 17 * 3600 + 0 * 60 + 0,
                "pause_start": 12 * 3600 + 0 * 60 + 0,
                "pause_end": 13 * 3600 + 0 * 60 + 0,
            },
            {
                "from_date": new Date("2017-01-01"),
                "to_date": new Date("2018-12-31"),
                "priority": 1,
                "weekday_id": 5,
                "start": 9 * 3600 + 0 * 60 + 0,
                "end": 17 * 3600 + 0 * 60 + 0,
                "pause_start": 12 * 3600 + 0 * 60 + 0,
                "pause_end": 13 * 3600 + 0 * 60 + 0,
            },
            {
                "from_date": new Date("2017-01-01"),
                "to_date": new Date("2018-12-31"),
                "priority": 1,
                "weekday_id": 6,
                "start": 9 * 3600 + 0 * 60 + 0,
                "end": 16 * 3600 + 0 * 60 + 0,
                "pause_start": 12 * 3600 + 0 * 60 + 0,
                "pause_end": 13 * 3600 + 0 * 60 + 0,
            },

        ]
    },
    { upsert: true }
);

print('dump complete');