(ns widgets.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :widgets
 (fn [db]
   (:widgets db)))

(re-frame/reg-sub
 :active-filter-id
 (fn [db]
   (:active-filter-id db)))

(re-frame/reg-sub
 :active-filter
 (fn [_ _]
   [(re-frame/subscribe [:filters])
    (re-frame/subscribe [:active-filter-id])])
 (fn [filters id]
   (get filters id)))

(re-frame/reg-sub
 :filters
 (fn [db]
   (:filters db)))

(re-frame/reg-sub
 :filtered-widgets
 (fn [_ _]
   [(re-frame/subscribe [:widgets])
    (re-frame/subscribe [:active-filter])])
 (fn [[widgets active-filter]]
   (filter (:fn active-filter) widgets)))
