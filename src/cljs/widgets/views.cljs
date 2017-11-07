(ns widgets.views
  (:require [re-frame.core :as re-frame]
            [widgets.subs :as subs]
            ))

(defn widget-card [widget]
  [:div {:class "widget"
         :style {:display "block" :padding "5px" :border "1px solid cornsilk" :margin "5px" :width "200px" :height "100px"}
         :key (:id widget)}
   [:h3 (:name widget)]
   [:p (str "$" (:price widget))]])

(defn filter-panel [filters active-filter]
  [:div {:class "filter-panel"}
   [:h2 "Filter widgets:"]
   [:div
    [:a {:href "#" :on-click (fn [e]
                               (.preventDefault e)
                               (re-frame/dispatch [:set-active-filter nil]))}
     "Show All"]]
   (for [filter (vals filters)]
     [:div
      [:a {:key (:id filter)
           :style {:color (str (if (= active-filter (:id filter)) "pink" ""))}
           :href "#"
           :on-click (fn [e]
                       (.preventDefault e)
                       (re-frame/dispatch [:set-active-filter (:id filter)]))}
        (:name filter)]])])

(defn main-panel []
  (let [widgets @(re-frame/subscribe [:filtered-widgets])
        active-filter @(re-frame/subscribe [:active-filter-id])
        filters @(re-frame/subscribe [:filters])
        filter-name (:name (get filters active-filter))]
    [:div {:class "widgets"}

     ;; The filtered widgets
     [:h2 (str "Active Filter: " (if filter-name filter-name "All"))]
     [:div {:style {:display "flex"}}
       (for [widget (vals widgets)]
         (widget-card widget))]

     [:hr]

     ;; The filter panel
     (filter-panel filters active-filter)]))
