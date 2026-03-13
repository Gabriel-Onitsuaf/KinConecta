# ENDPOINTS

Listado de endpoints REST expuestos por los controladores del backend.

Generado automaticamente: 2026-03-05 21:54

Base URL local sugerida: `http://localhost:8080`

## Convenciones

- Todos los endpoints reciben/retornan JSON salvo que se indique lo contrario.
- `POST` crea recursos.
- `GET` consulta recursos.
- `PUT` actualiza recursos completos.
- `DELETE` elimina recursos.

## ContactMessageController

Archivo: `src\main\java\org\generation\socialNetwork\contact\controller\ContactMessageController.java`

Endpoint base: `/api/contact_messages`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/contact_messages` | Crea un nuevo registro. |
| GET | `/api/contact_messages` | Obtiene todos los registros. |
| GET | `/api/contact_messages/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/contact_messages/{id}` | Actualiza un registro existente. |
| DELETE | `/api/contact_messages/{id}` | Elimina un registro por identificador. |

## NewsletterSubscriptionController

Archivo: `src\main\java\org\generation\socialNetwork\contact\controller\NewsletterSubscriptionController.java`

Endpoint base: `/api/newsletter_subscriptions`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/newsletter_subscriptions` | Crea un nuevo registro. |
| GET | `/api/newsletter_subscriptions` | Obtiene todos los registros. |
| GET | `/api/newsletter_subscriptions/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/newsletter_subscriptions/{id}` | Actualiza un registro existente. |
| DELETE | `/api/newsletter_subscriptions/{id}` | Elimina un registro por identificador. |

## FaqCategoryController

Archivo: `src\main\java\org\generation\socialNetwork\faq\controller\FaqCategoryController.java`

Endpoint base: `/api/faq_categories`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/faq_categories` | Crea un nuevo registro. |
| GET | `/api/faq_categories` | Obtiene todos los registros. |
| GET | `/api/faq_categories/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/faq_categories/{id}` | Actualiza un registro existente. |
| DELETE | `/api/faq_categories/{id}` | Elimina un registro por identificador. |

## FaqItemController

Archivo: `src\main\java\org\generation\socialNetwork\faq\controller\FaqItemController.java`

Endpoint base: `/api/faq_items`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/faq_items` | Crea un nuevo registro. |
| GET | `/api/faq_items` | Obtiene todos los registros. |
| GET | `/api/faq_items/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/faq_items/{id}` | Actualiza un registro existente. |
| DELETE | `/api/faq_items/{id}` | Elimina un registro por identificador. |

## SupportTicketAttachmentController

Archivo: `src\main\java\org\generation\socialNetwork\help\controller\SupportTicketAttachmentController.java`

Endpoint base: `/api/support_ticket_attachments`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/support_ticket_attachments` | Crea un nuevo registro. |
| GET | `/api/support_ticket_attachments` | Obtiene todos los registros. |
| GET | `/api/support_ticket_attachments/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/support_ticket_attachments/{id}` | Actualiza un registro existente. |
| DELETE | `/api/support_ticket_attachments/{id}` | Elimina un registro por identificador. |

## SupportTicketController

Archivo: `src\main\java\org\generation\socialNetwork\help\controller\SupportTicketController.java`

Endpoint base: `/api/support_tickets`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/support_tickets` | Crea un nuevo registro. |
| GET | `/api/support_tickets` | Obtiene todos los registros. |
| GET | `/api/support_tickets/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/support_tickets/{id}` | Actualiza un registro existente. |
| DELETE | `/api/support_tickets/{id}` | Elimina un registro por identificador. |

## CompatibilityAnswerController

Archivo: `src\main\java\org\generation\socialNetwork\matching\controller\CompatibilityAnswerController.java`

Endpoint base: `/api/compatibility_answers`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/compatibility_answers` | Crea un nuevo registro. |
| GET | `/api/compatibility_answers` | Obtiene todos los registros. |
| GET | `/api/compatibility_answers/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/compatibility_answers/{id}` | Actualiza un registro existente. |
| DELETE | `/api/compatibility_answers/{id}` | Elimina un registro por identificador. |

## CompatibilityProfileController

Archivo: `src\main\java\org\generation\socialNetwork\matching\controller\CompatibilityProfileController.java`

Endpoint base: `/api/compatibility_profiles`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/compatibility_profiles` | Crea un nuevo registro. |
| GET | `/api/compatibility_profiles` | Obtiene todos los registros. |
| GET | `/api/compatibility_profiles/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/compatibility_profiles/{id}` | Actualiza un registro existente. |
| DELETE | `/api/compatibility_profiles/{id}` | Elimina un registro por identificador. |

## FavoriteGuideController

Archivo: `src\main\java\org\generation\socialNetwork\matching\controller\FavoriteGuideController.java`

Endpoint base: `/api/favorite_guides`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/favorite_guides` | Crea un nuevo registro. |
| GET | `/api/favorite_guides` | Obtiene todos los registros. |
| GET | `/api/favorite_guides/{touristId}/{guideId}` | Obtiene un registro por identificador. |
| PUT | `/api/favorite_guides/{touristId}/{guideId}` | Actualiza un registro existente. |
| DELETE | `/api/favorite_guides/{touristId}/{guideId}` | Elimina un registro por identificador. |

## FavoriteTourController

Archivo: `src\main\java\org\generation\socialNetwork\matching\controller\FavoriteTourController.java`

Endpoint base: `/api/favorite_tours`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/favorite_tours` | Crea un nuevo registro. |
| GET | `/api/favorite_tours` | Obtiene todos los registros. |
| GET | `/api/favorite_tours/{touristId}/{tourId}` | Obtiene un registro por identificador. |
| PUT | `/api/favorite_tours/{touristId}/{tourId}` | Actualiza un registro existente. |
| DELETE | `/api/favorite_tours/{touristId}/{tourId}` | Elimina un registro por identificador. |

## ChatMessageController

Archivo: `src\main\java\org\generation\socialNetwork\messenger\controller\ChatMessageController.java`

Endpoint base: `/api/chat_messages`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/chat_messages` | Crea un nuevo registro. |
| GET | `/api/chat_messages` | Obtiene todos los registros. |
| GET | `/api/chat_messages/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/chat_messages/{id}` | Actualiza un registro existente. |
| DELETE | `/api/chat_messages/{id}` | Elimina un registro por identificador. |

## ChatThreadController

Archivo: `src\main\java\org\generation\socialNetwork\messenger\controller\ChatThreadController.java`

Endpoint base: `/api/chat_threads`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/chat_threads` | Crea un nuevo registro. |
| GET | `/api/chat_threads` | Obtiene todos los registros. |
| GET | `/api/chat_threads/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/chat_threads/{id}` | Actualiza un registro existente. |
| DELETE | `/api/chat_threads/{id}` | Elimina un registro por identificador. |

## NotificationController

Archivo: `src\main\java\org\generation\socialNetwork\notifications\controller\NotificationController.java`

Endpoint base: `/api/notifications`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/notifications` | Crea un nuevo registro. |
| GET | `/api/notifications` | Obtiene todos los registros. |
| GET | `/api/notifications/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/notifications/{id}` | Actualiza un registro existente. |
| DELETE | `/api/notifications/{id}` | Elimina un registro por identificador. |

## GuideAdaptationController

Archivo: `src\main\java\org\generation\socialNetwork\profileGuide\controller\GuideAdaptationController.java`

Endpoint base: `/api/guide_adaptations`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/guide_adaptations` | Crea un nuevo registro. |
| GET | `/api/guide_adaptations` | Obtiene todos los registros. |
| GET | `/api/guide_adaptations/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/guide_adaptations/{id}` | Actualiza un registro existente. |
| DELETE | `/api/guide_adaptations/{id}` | Elimina un registro por identificador. |

## GuideCalendarEventController

Archivo: `src\main\java\org\generation\socialNetwork\profileGuide\controller\GuideCalendarEventController.java`

Endpoint base: `/api/guide_calendar_events`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/guide_calendar_events` | Crea un nuevo registro. |
| GET | `/api/guide_calendar_events` | Obtiene todos los registros. |
| GET | `/api/guide_calendar_events/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/guide_calendar_events/{id}` | Actualiza un registro existente. |
| DELETE | `/api/guide_calendar_events/{id}` | Elimina un registro por identificador. |

## GuideCertificationController

Archivo: `src\main\java\org\generation\socialNetwork\profileGuide\controller\GuideCertificationController.java`

Endpoint base: `/api/guide_certifications`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/guide_certifications` | Crea un nuevo registro. |
| GET | `/api/guide_certifications` | Obtiene todos los registros. |
| GET | `/api/guide_certifications/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/guide_certifications/{id}` | Actualiza un registro existente. |
| DELETE | `/api/guide_certifications/{id}` | Elimina un registro por identificador. |

## GuideExpertiseAreaController

Archivo: `src\main\java\org\generation\socialNetwork\profileGuide\controller\GuideExpertiseAreaController.java`

Endpoint base: `/api/guide_expertise_areas`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/guide_expertise_areas` | Crea un nuevo registro. |
| GET | `/api/guide_expertise_areas` | Obtiene todos los registros. |
| GET | `/api/guide_expertise_areas/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/guide_expertise_areas/{id}` | Actualiza un registro existente. |
| DELETE | `/api/guide_expertise_areas/{id}` | Elimina un registro por identificador. |

## GuideLocationController

Archivo: `src\main\java\org\generation\socialNetwork\profileGuide\controller\GuideLocationController.java`

Endpoint base: `/api/guide_locations`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/guide_locations` | Crea un nuevo registro. |
| GET | `/api/guide_locations` | Obtiene todos los registros. |
| GET | `/api/guide_locations/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/guide_locations/{id}` | Actualiza un registro existente. |
| DELETE | `/api/guide_locations/{id}` | Elimina un registro por identificador. |

## GuideProfileController

Archivo: `src\main\java\org\generation\socialNetwork\profileGuide\controller\GuideProfileController.java`

Endpoint base: `/api/guide_profiles`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/guide_profiles` | Crea un nuevo registro. |
| GET | `/api/guide_profiles` | Obtiene todos los registros. |
| GET | `/api/guide_profiles/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/guide_profiles/{id}` | Actualiza un registro existente. |
| DELETE | `/api/guide_profiles/{id}` | Elimina un registro por identificador. |

## GuideProfileExpertiseController

Archivo: `src\main\java\org\generation\socialNetwork\profileGuide\controller\GuideProfileExpertiseController.java`

Endpoint base: `/api/guide_profile_expertise`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/guide_profile_expertise` | Crea un nuevo registro. |
| GET | `/api/guide_profile_expertise` | Obtiene todos los registros. |
| GET | `/api/guide_profile_expertise/{userId}/{expertiseId}` | Obtiene un registro por identificador. |
| PUT | `/api/guide_profile_expertise/{userId}/{expertiseId}` | Actualiza un registro existente. |
| DELETE | `/api/guide_profile_expertise/{userId}/{expertiseId}` | Elimina un registro por identificador. |

## GuideProfileLanguageController

Archivo: `src\main\java\org\generation\socialNetwork\profileGuide\controller\GuideProfileLanguageController.java`

Endpoint base: `/api/guide_profile_languages`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/guide_profile_languages` | Crea un nuevo registro. |
| GET | `/api/guide_profile_languages` | Obtiene todos los registros. |
| GET | `/api/guide_profile_languages/{userId}/{languageCode}` | Obtiene un registro por identificador. |
| PUT | `/api/guide_profile_languages/{userId}/{languageCode}` | Actualiza un registro existente. |
| DELETE | `/api/guide_profile_languages/{userId}/{languageCode}` | Elimina un registro por identificador. |

## IncomeTransactionController

Archivo: `src\main\java\org\generation\socialNetwork\profileGuide\controller\IncomeTransactionController.java`

Endpoint base: `/api/income_transactions`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/income_transactions` | Crea un nuevo registro. |
| GET | `/api/income_transactions` | Obtiene todos los registros. |
| GET | `/api/income_transactions/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/income_transactions/{id}` | Actualiza un registro existente. |
| DELETE | `/api/income_transactions/{id}` | Elimina un registro por identificador. |

## WithdrawalRequestController

Archivo: `src\main\java\org\generation\socialNetwork\profileGuide\controller\WithdrawalRequestController.java`

Endpoint base: `/api/withdrawal_requests`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/withdrawal_requests` | Crea un nuevo registro. |
| GET | `/api/withdrawal_requests` | Obtiene todos los registros. |
| GET | `/api/withdrawal_requests/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/withdrawal_requests/{id}` | Actualiza un registro existente. |
| DELETE | `/api/withdrawal_requests/{id}` | Elimina un registro por identificador. |

## InterestController

Archivo: `src\main\java\org\generation\socialNetwork\profileTourist\controller\InterestController.java`

Endpoint base: `/api/interests`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/interests` | Crea un nuevo registro. |
| GET | `/api/interests` | Obtiene todos los registros. |
| GET | `/api/interests/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/interests/{id}` | Actualiza un registro existente. |
| DELETE | `/api/interests/{id}` | Elimina un registro por identificador. |

## TouristProfileController

Archivo: `src\main\java\org\generation\socialNetwork\profileTourist\controller\TouristProfileController.java`

Endpoint base: `/api/tourist_profiles`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/tourist_profiles` | Crea un nuevo registro. |
| GET | `/api/tourist_profiles` | Obtiene todos los registros. |
| GET | `/api/tourist_profiles/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/tourist_profiles/{id}` | Actualiza un registro existente. |
| DELETE | `/api/tourist_profiles/{id}` | Elimina un registro por identificador. |

## TouristProfileInterestController

Archivo: `src\main\java\org\generation\socialNetwork\profileTourist\controller\TouristProfileInterestController.java`

Endpoint base: `/api/tourist_profile_interests`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/tourist_profile_interests` | Crea un nuevo registro. |
| GET | `/api/tourist_profile_interests` | Obtiene todos los registros. |
| GET | `/api/tourist_profile_interests/{userId}/{interestId}` | Obtiene un registro por identificador. |
| PUT | `/api/tourist_profile_interests/{userId}/{interestId}` | Actualiza un registro existente. |
| DELETE | `/api/tourist_profile_interests/{userId}/{interestId}` | Elimina un registro por identificador. |

## TouristProfileLanguageController

Archivo: `src\main\java\org\generation\socialNetwork\profileTourist\controller\TouristProfileLanguageController.java`

Endpoint base: `/api/tourist_profile_languages`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/tourist_profile_languages` | Crea un nuevo registro. |
| GET | `/api/tourist_profile_languages` | Obtiene todos los registros. |
| GET | `/api/tourist_profile_languages/{userId}/{languageCode}` | Obtiene un registro por identificador. |
| PUT | `/api/tourist_profile_languages/{userId}/{languageCode}` | Actualiza un registro existente. |
| DELETE | `/api/tourist_profile_languages/{userId}/{languageCode}` | Elimina un registro por identificador. |

## ReviewController

Archivo: `src\main\java\org\generation\socialNetwork\reviews\controller\ReviewController.java`

Endpoint base: `/api/reviews`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/reviews` | Crea un nuevo registro. |
| GET | `/api/reviews` | Obtiene todos los registros. |
| GET | `/api/reviews/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/reviews/{id}` | Actualiza un registro existente. |
| DELETE | `/api/reviews/{id}` | Elimina un registro por identificador. |

## ReviewReplyController

Archivo: `src\main\java\org\generation\socialNetwork\reviews\controller\ReviewReplyController.java`

Endpoint base: `/api/review_replies`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/review_replies` | Crea un nuevo registro. |
| GET | `/api/review_replies` | Obtiene todos los registros. |
| GET | `/api/review_replies/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/review_replies/{id}` | Actualiza un registro existente. |
| DELETE | `/api/review_replies/{id}` | Elimina un registro por identificador. |

## DestinationController

Archivo: `src\main\java\org\generation\socialNetwork\tours\controller\DestinationController.java`

Endpoint base: `/api/destinations`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/destinations` | Crea un nuevo registro. |
| GET | `/api/destinations` | Obtiene todos los registros. |
| GET | `/api/destinations/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/destinations/{id}` | Actualiza un registro existente. |
| DELETE | `/api/destinations/{id}` | Elimina un registro por identificador. |

## TourCategoryController

Archivo: `src\main\java\org\generation\socialNetwork\tours\controller\TourCategoryController.java`

Endpoint base: `/api/tour_categories`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/tour_categories` | Crea un nuevo registro. |
| GET | `/api/tour_categories` | Obtiene todos los registros. |
| GET | `/api/tour_categories/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/tour_categories/{id}` | Actualiza un registro existente. |
| DELETE | `/api/tour_categories/{id}` | Elimina un registro por identificador. |

## TourController

Archivo: `src\main\java\org\generation\socialNetwork\tours\controller\TourController.java`

Endpoint base: `/api/tours`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/tours` | Crea un nuevo registro. |
| GET | `/api/tours` | Obtiene todos los registros. |
| GET | `/api/tours/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/tours/{id}` | Actualiza un registro existente. |
| DELETE | `/api/tours/{id}` | Elimina un registro por identificador. |

## TourDestinationController

Archivo: `src\main\java\org\generation\socialNetwork\tours\controller\TourDestinationController.java`

Endpoint base: `/api/tour_destinations`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/tour_destinations` | Crea un nuevo registro. |
| GET | `/api/tour_destinations` | Obtiene todos los registros. |
| GET | `/api/tour_destinations/{tourId}/{destinationId}` | Obtiene un registro por identificador. |
| PUT | `/api/tour_destinations/{tourId}/{destinationId}` | Actualiza un registro existente. |
| DELETE | `/api/tour_destinations/{tourId}/{destinationId}` | Elimina un registro por identificador. |

## TourIncludedItemController

Archivo: `src\main\java\org\generation\socialNetwork\tours\controller\TourIncludedItemController.java`

Endpoint base: `/api/tour_included_items`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/tour_included_items` | Crea un nuevo registro. |
| GET | `/api/tour_included_items` | Obtiene todos los registros. |
| GET | `/api/tour_included_items/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/tour_included_items/{id}` | Actualiza un registro existente. |
| DELETE | `/api/tour_included_items/{id}` | Elimina un registro por identificador. |

## TripBookingController

Archivo: `src\main\java\org\generation\socialNetwork\tours\controller\TripBookingController.java`

Endpoint base: `/api/trip_bookings`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/trip_bookings` | Crea un nuevo registro. |
| GET | `/api/trip_bookings` | Obtiene todos los registros. |
| GET | `/api/trip_bookings/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/trip_bookings/{id}` | Actualiza un registro existente. |
| DELETE | `/api/trip_bookings/{id}` | Elimina un registro por identificador. |

## TripStatusHistoryController

Archivo: `src\main\java\org\generation\socialNetwork\tours\controller\TripStatusHistoryController.java`

Endpoint base: `/api/trip_status_history`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/trip_status_history` | Crea un nuevo registro. |
| GET | `/api/trip_status_history` | Obtiene todos los registros. |
| GET | `/api/trip_status_history/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/trip_status_history/{id}` | Actualiza un registro existente. |
| DELETE | `/api/trip_status_history/{id}` | Elimina un registro por identificador. |

## AuthSessionController

Archivo: `src\main\java\org\generation\socialNetwork\users\controller\AuthSessionController.java`

Endpoint base: `/api/auth_sessions`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/auth_sessions` | Crea un nuevo registro. |
| GET | `/api/auth_sessions` | Obtiene todos los registros. |
| GET | `/api/auth_sessions/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/auth_sessions/{id}` | Actualiza un registro existente. |
| DELETE | `/api/auth_sessions/{id}` | Elimina un registro por identificador. |

## LanguageController

Archivo: `src\main\java\org\generation\socialNetwork\users\controller\LanguageController.java`

Endpoint base: `/api/languages`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/languages` | Crea un nuevo registro. |
| GET | `/api/languages` | Obtiene todos los registros. |
| GET | `/api/languages/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/languages/{id}` | Actualiza un registro existente. |
| DELETE | `/api/languages/{id}` | Elimina un registro por identificador. |

## UserController

Archivo: `src\main\java\org\generation\socialNetwork\users\controller\UserController.java`

Endpoint base: `/api/users`

| Metodo | Endpoint | Descripcion |
| --- | --- | --- |
| POST | `/api/users` | Crea un nuevo registro. |
| GET | `/api/users` | Obtiene todos los registros. |
| GET | `/api/users/{id}` | Obtiene un registro por identificador. |
| PUT | `/api/users/{id}` | Actualiza un registro existente. |
| DELETE | `/api/users/{id}` | Elimina un registro por identificador. |

