(ns widgets.events
  (:require [re-frame.core :as re-frame]
            [widgets.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn [_ _]
   db/default-db))

(re-frame/reg-event-db
 :set-active-filter
 (fn [db [_ filter-id]]
   (assoc db :active-filter-id filter-id)))
