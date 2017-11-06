(ns widgets.views
  (:require [re-frame.core :as re-frame]
            [widgets.subs :as subs]
            ))

(defn widget-card [widget]
  [:div {:class "widget"}
   [:h3 (:name widget)]])

(defn filter-panel [filters]
  (let [filters @(re-frame/subscribe [:filters])
        active-filter @(re-frame/subscribe [:active-filter])]
  [:div {:class "filter-panel"}
   [:h3 "Filter widgets"
    (for [filter filters]
      [:div
       [:a {:on-click #(re-frame/dispatch [:set-active-filter (:id filter)])}
        (:name filter)]])]]))

(defn main-panel []
  (let [widgets @(re-frame/subscribe [:filtered-widgets])
        active-filter @(re-frame/subscribe [:active-filter])]
    [:div {:class "widgets"}
     [:h2 (str "Active Filter:" (:name active-filter))]
     (for [widget (vals widgets)]
       (widget-card widget))]))
