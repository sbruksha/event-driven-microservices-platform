/**
 * Creates pre-filled demo appointment
 */

print('dump start');

db.appointments.update(
    { "_id": "demo" },
    {
        "_id": "demo",
        "client": {
            "name": "demo"
        },
        "store": {
            "name": "demo"
        },
        "description": "Demo Appointment",
        "start": new Date("2017-12-20T15:00:00"),
        "end": new Date("2017-12-20T15:20:00"),
        "createdby": {
            "name": "demo"
        },
        "created": new Date("2017-12-10T15:00:00"),
        "services":[
            {
                "_id": "Pick up",
                "duration": 20
            }
        ]
    },
    { upsert: true }
);

db.attendances.update(
    { "_id": "demo" },
    {
        "_id": "demo",
        "appointment": {
            "name": "demo"
        },
        "checkedin": new Date("2017-12-20T15:00:00"),
        "undertreatment": new Date("2017-12-20T15:05:00"),
        "finished": new Date("2017-12-20T15:25:00")
    },
    { upsert: true }
);

db.services.update(
    { "_id": "Drop off" },
    {
        "_id": "Drop off",
        "duration": 15
    },
    { upsert: true }
);
db.services.update(
    { "_id": "Pick up" },
    {
        "_id": "Pick up",
        "duration": 20
    },
    { upsert: true }
);

print('dump complete');