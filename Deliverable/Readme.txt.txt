The project Provisioning SDP is basically for internet service providers basic functions. 
I am sharing part of my code which is for functionality :
1) Adding a customer
2) Update customer details
There are many more services that I have implemented for this project and have worked on different other APIs for similar projects

1) ADD CUSTOMER

This functionality uses different APIs and creates a customer with different details and service location details.
The classes involved are CreationProcessor and several Wrapper classes which are classes with the help of which we use the functionalities of different APIs.

The CreationProcessorTest Class is basically the Test Case using Power Mockito.
SOAPUI Sample Request -- (? should be replaced to fill in data )
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:head="http://www.wildblue.viasat.com/XMLSchema/v3.0/Header" xmlns:prov="http://www.wildblue.viasat.com/XMLSchema/v4/webservice/ProvisioningFacade">
   <soapenv:Header>
      <head:wildBlueHeader>
         <head:invokedBy>
            <head:username>?</head:username>
            <head:application>?</head:application>
         </head:invokedBy>
      </head:wildBlueHeader>
   </soapenv:Header>
   <soapenv:Body>
      <prov:addCustomerHierarchy>
         <prov:transactionReference>?</prov:transactionReference>
         <prov:customerHierarchy>
            <prov:customer>
               <prov:serviceProviderType>?</prov:serviceProviderType>
               <prov:customerReference>?</prov:customerReference>
               <prov:customerType>?</prov:customerType>
               <!--Optional:-->
               <prov:businessName>?</prov:businessName>
               <prov:customerContact>
                  <person>
                     <firstName>?</firstName>
                     <!--Optional:-->
                     <middleName>?</middleName>
                     <lastName>?</lastName>
                     <!--Optional:-->
                     <suffix>?</suffix>
                  </person>
                  <contactInfo>
                     <emailAddress>?</emailAddress>
                     <primaryPhone>?</primaryPhone>
                     <!--Optional:-->
                     <secondaryPhone>?</secondaryPhone>
                     <contactType>?</contactType>
                     <location>
                        <!--Optional:-->
                        <GeoPosition>
                           <latitude>?</latitude>
                           <longitude>?</longitude>
                        </GeoPosition>
                        <!--Optional:-->
                        <Address type="?">
                           <countryCode>?</countryCode>
                           <!--Optional:-->
                           <postalCode>?</postalCode>
                           <!--Optional:-->
                           <region>?</region>
                           <!--Optional:-->
                           <municipality>?</municipality>
                           <!--Zero or more repetitions:-->
                           <addressLine>?</addressLine>
                        </Address>
                     </location>
                  </contactInfo>
               </prov:customerContact>
            </prov:customer>
            <!--Zero or more repetitions:-->
            <prov:accountHierarchy>
               <prov:account>
                  <prov:customerReference>?</prov:customerReference>
                  <prov:accountReference>?</prov:accountReference>
                  <prov:accountContact>
                     <person>
                        <firstName>?</firstName>
                        <!--Optional:-->
                        <middleName>?</middleName>
                        <lastName>?</lastName>
                        <!--Optional:-->
                        <suffix>?</suffix>
                     </person>
                     <contactInfo>
                        <emailAddress>?</emailAddress>
                        <primaryPhone>?</primaryPhone>
                        <!--Optional:-->
                        <secondaryPhone>?</secondaryPhone>
                        <contactType>?</contactType>
                        <location>
                           <!--Optional:-->
                           <GeoPosition>
                              <latitude>?</latitude>
                              <longitude>?</longitude>
                           </GeoPosition>
                           <!--Optional:-->
                           <Address type="?">
                              <countryCode>?</countryCode>
                              <!--Optional:-->
                              <postalCode>?</postalCode>
                              <!--Optional:-->
                              <region>?</region>
                              <!--Optional:-->
                              <municipality>?</municipality>
                              <!--Zero or more repetitions:-->
                              <addressLine>?</addressLine>
                           </Address>
                        </location>
                     </contactInfo>
                  </prov:accountContact>
                  <prov:accountType>?</prov:accountType>
               </prov:account>
               <!--Zero or more repetitions:-->
               <prov:serviceAgreementHierarchy>
                  <prov:serviceAgreement>
                     <prov:accountReference>?</prov:accountReference>
                     <prov:serviceAgreementReference>?</prov:serviceAgreementReference>
                     <prov:salesChannelType>?</prov:salesChannelType>
                     <prov:serviceContact>
                        <person>
                           <firstName>?</firstName>
                           <!--Optional:-->
                           <middleName>?</middleName>
                           <lastName>?</lastName>
                           <!--Optional:-->
                           <suffix>?</suffix>
                        </person>
                        <contactInfo>
                           <emailAddress>?</emailAddress>
                           <primaryPhone>?</primaryPhone>
                           <!--Optional:-->
                           <secondaryPhone>?</secondaryPhone>
                           <contactType>?</contactType>
                           <location>
                              <!--Optional:-->
                              <GeoPosition>
                                 <latitude>?</latitude>
                                 <longitude>?</longitude>
                              </GeoPosition>
                              <!--Optional:-->
                              <Address type="?">
                                 <countryCode>?</countryCode>
                                 <!--Optional:-->
                                 <postalCode>?</postalCode>
                                 <!--Optional:-->
                                 <region>?</region>
                                 <!--Optional:-->
                                 <municipality>?</municipality>
                                 <!--Zero or more repetitions:-->
                                 <addressLine>?</addressLine>
                              </Address>
                           </location>
                        </contactInfo>
                     </prov:serviceContact>
                     <prov:beamInfo>
                        <beamTechnicalInfo>
                           <beamNumber>?</beamNumber>
                           <satelliteName>?</satelliteName>
                           <polarization>?</polarization>
                           <antennaLookAngles>
                              <azimuth>?</azimuth>
                              <elevation>?</elevation>
                              <skew>?</skew>
                              <boomArmAngle>?</boomArmAngle>
                           </antennaLookAngles>
                           <antennaPointingAid>?</antennaPointingAid>
                           <!--Optional:-->
                           <gatewayId>?</gatewayId>
                           <!--Optional:-->
                           <gatewayName>?</gatewayName>
                           <modemInstallCode>?</modemInstallCode>
                           <!--Optional:-->
                           <customerCode>?</customerCode>
                           <equipmentType>
                              <modemType>?</modemType>
                              <triaType>?</triaType>
                           </equipmentType>
                        </beamTechnicalInfo>
                        <beamSalesInfo>
                           <salesStatus>?</salesStatus>
                           <overrideStatus>?</overrideStatus>
                           <isPrimary>?</isPrimary>
                        </beamSalesInfo>
                     </prov:beamInfo>
                     <prov:startDate>?</prov:startDate>
                     <prov:installationLogin>?</prov:installationLogin>
                     <prov:installationPassword>?</prov:installationPassword>
                     <!--Optional:-->
                     <prov:ClientClass>?</prov:ClientClass>
                     <!--Optional:-->
                     <prov:MACAddress>?</prov:MACAddress>
                     <!--Optional:-->
                     <prov:status>?</prov:status>
                  </prov:serviceAgreement>
                  <!--Zero or more repetitions:-->
                  <prov:ServiceItem>
                     <prov:serviceAgreementReference>?</prov:serviceAgreementReference>
                     <prov:serviceItemReference>?</prov:serviceItemReference>
                     <prov:name>?</prov:name>
                     <prov:type>?</prov:type>
                     <prov:catalogNumber>?</prov:catalogNumber>
                     <!--Optional:-->
                     <prov:promotionCode>?</prov:promotionCode>
                     <!--Optional:-->
                     <prov:selfCareLoginName>?</prov:selfCareLoginName>
                     <!--Optional:-->
                     <prov:selfCarePassword>?</prov:selfCarePassword>
                     <!--Optional:-->
                     <prov:startDate>?</prov:startDate>
                     <!--Optional:-->
                     <prov:status>?</prov:status>
                  </prov:ServiceItem>
               </prov:serviceAgreementHierarchy>
            </prov:accountHierarchy>
         </prov:customerHierarchy>
      </prov:addCustomerHierarchy>
   </soapenv:Body>
</soapenv:Envelope>


2) UPDATE CONTACTS

This functinality updates the data for an existing customer.
The class name is UpdateProcessor method-updateContacts

The UpdateProcessorTest is basically Test Class using Power Mockito.

I have worked on other APIs that has database interaction using hibernate.

SOAPUI Sample Request -- (? should be replaced to fill in data )
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:head="http://www.wildblue.viasat.com/XMLSchema/v3.0/Header" xmlns:prov="http://www.wildblue.viasat.com/XMLSchema/v4/webservice/ProvisioningFacade">
   <soapenv:Header>
      <head:wildBlueHeader>
         <head:invokedBy>
            <head:username>?</head:username>
            <head:application>?</head:application>
         </head:invokedBy>
      </head:wildBlueHeader>
   </soapenv:Header>
   <soapenv:Body>
      <prov:updateContacts>
           <prov:transactionReference>43434343</prov:transactionReference>
         <prov:serviceAgreementReference>403588898</prov:serviceAgreementReference>
         <prov:salesChannelName>SF_PORTAL</prov:salesChannelName>
         <prov:correctedContact>
            <!--Optional:-->
            <prov:person>
               <firstName>Kim</firstName>
               <!--Optional:-->
               <middleName>k</middleName>
               <lastName>ms</lastName>
               <!--Optional:-->
               <suffix>Ms</suffix>
            </prov:person>
            <!--Optional:-->
            <prov:serviceAddress>
               <prov:countryCode>US</prov:countryCode>
               <!--Optional:-->
               <prov:postalCode>35578-3048</prov:postalCode>
               <!--Optional:-->
               <prov:region>AL</prov:region>
               <!--Optional:-->
               <prov:municipality>Englewood</prov:municipality>
               <!--Zero or more repetitions:-->
               <prov:addressLine>8331 North valley</prov:addressLine>
               <prov:antennaLookAngles>
                  <azimuth>181.65</azimuth>
                  <elevation>41.595</elevation>
                  <skew>710.575</skew>
                  <boomArmAngle>21.1900000000000055</boomArmAngle>
               </prov:antennaLookAngles>
            </prov:serviceAddress>
            <!--Optional:-->
            <prov:emailAddress>dd@gail.com</prov:emailAddress>
            <!--Optional:-->
            <prov:phonePrimary>2166666662</prov:phonePrimary>
            <!--Optional:-->
            <prov:phoneSecondary>6576570085</prov:phoneSecondary>
         </prov:correctedContact>
      </prov:updateContacts>
   </soapenv:Body>
</soapenv:Envelope>


This is the best way to implement the functionality - Having helper APIs and the functionality is divided between APIs based on business and then biforcate and use APIs as and when needed.