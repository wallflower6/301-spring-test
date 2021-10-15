document.getElementById("loginBtn").addEventListener("click", (e) => {
    $.ajax({
        url:"/login",
        type:"POST",
        data: JSON.stringify({
            "Password": "Test123"
        }),
        contentType: "application/json",
        dataType: "json"
    })
});

document.getElementById("signupBtn").addEventListener("click", (e) => {
    var details = {
        "Profile": {
            "Title": "MR",
            "IC": "S20160309A",
            "FirstName": "ISAAC",
            "LastName": "GOH",
            "NickName": "NICKFURY",
            "DOB": "1980-03-15T00:00:00",
            "DefaultAddress": "HOME",
            "HomePhone": "61111111",
            "HomePhoneCountryCode": null,
            "OfficePhone": null,
            "OfficePhoneCountryCode": null,
            "Mobile": "92222222",
            "MobileCountryCode": "65",
            "Email": null,
            "GenderCode": "M",
            "NationalityCode": "SG",
            "Remark": null,
            "JoinLocation": "WEB",
            "DateJoined": "2016-03-08T15:58:20.8749009+08:00",
            "Addresses": [
                {
                    "AddressType": "HOME",
                    "Address1": "101 PASIR PANJANG ROAD",
                    "Address2": null,
                    "Address3": null,
                    "Address4": null,
                    "State": "SINGAPORE",
                    "StateValue": null,
                    "City": null,
                    "CityCode": null,
                    "District": null,
                    "DistrictCode": null,
                    "SubDistrict": null,
                    "SubDistrictCode": null,
                    "PostalCode": "118520",
                    "CountryCode": "SG"
                },
                {
                    "AddressType": "BILLING",
                    "Address1": "101 PASIR PANJANG ROAD",
                    "Address2": null,
                    "Address3": null,
                    "Address4": null,
                    "State": "SINGAPORE",
                    "StateValue": null,
                    "City": null,
                    "CityCode": null,
                    "District": null,
                    "DistrictCode": null,
                    "SubDistrict": null,
                    "SubDistrictCode": null,
                    "PostalCode": "118520",
                    "CountryCode": "SG"
                }
            ],
            "Interests": [
                {
                    "Code":"INTE003",
                    "DisplayText":"IT/Electronics/Telecommunications",
                    "Value":"Y"
                },
                {
                    "Code":"INTE004",
                    "DisplayText":"Movies/Entertainment/Music",
                    "Value":"Y"
                },
                {
                    "Code":"INTE005",
                    "DisplayText":"Household & Lifestyle",
                    "Value":"N"
                }
            ],
            "ContactPreferences": [
                {
                    "Code": "CLUB21_MAIL",
                    "DisplayText": "",
                    "Value": "NA"
                },
                {
                    "Code": "CLUB21_EMAIL",
                    "DisplayText": "",
                    "Value": "NA"
                },
                {
                    "Code": "CLUB21_SMS",
                    "DisplayText": "",
                    "Value": "NA"
                }
            ],
            "Properties": [
                // {
                //     "Name": "Personal Income",
                //     "Value": "INCO001"
                // },
                // {
                //     "Name": "Occupation",
                //     "Value": "OCCU003"
                // }
            ],
            "ContactPersons": [
                {
                    "RefNumber": "3140e67d-821c-4378-b832-ccb5d5d1233e",
                    "Type": "SPOUSE",
                    "FirstName": "PERSON1",
                    "LastName": "",
                    "IC": "S4534534R",
                    "DOB": "1982-03-5",
                    "Gender": "F"
                },
                {
                    "RefNumber": "782966d3-a7b6-4c54-9566-578c8dec577a",
                    "Type": "CHILD",
                    "FirstName": "PERSON2",
                    "LastName": "",
                    "IC": "S4534994R",
                    "DOB": "2010-06-5",
                    "Gender": "M"
                }
            ]
        },
        "Membership": {
            "MemberType": "e-Member",
            "LocationCode": "HQ",
            "Date": "2016-03-08T11:29:47+08:00",
            "CardName": "",
            "MemberNumber": "",
            "Description": "",
            "Registrator": "",
            "SalePerson": "",
            "PromoCode": null
        },
        "Purchase": {
            "TransactionDate": "2016-03-08T11:29:47+08:00",
            "StoreCode": "HQ",
            "DeviceType": "",
            "DeviceId": "",
            "POSId": "",
            "OperatorId": "",
            "Description": "",
            "ReceiptNumber": "ORDER123456",
            "PromotionCodes": [
                {
                    "Code": "PROMO01"
                }
            ],
            "Items": [
                {
                    "Currency": "SGD",
                    "ItemCode": "PUR01",
                    "Amount": 0
                }
            ],
            "Payments": [
                {
                    "PaymentType": "CASH",
                    "Currency": "SGD",
                    "Amount": 0
                }
            ]
        }
    }
    $.ajax({
        url:"/signup",
        type:"POST",
        data: JSON.stringify(details),
        contentType: "application/json",
        dataType: "json"
    });
});

