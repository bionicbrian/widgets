(ns widgets.db)

(def default-db
  {:widgets
   {:a54c8123-3d5e-489e-963b-8dbfd6a16879
    {:id :a54c8123-3d5e-489e-963b-8dbfd6a16879
     :tags ["cog" "cogswell" "jumbo" "expert"]
     :name "Jumbo Cogswell Cog 4K"
     :price 9.99
     :manufacturer-id :f75691f1-21b3-44c2-b576-e7c88b563bb5
     :manufactured-time 1509976458043
     :thumbnail "cogswell-4k-jumbo.png"
     :description "This is the excellent JUMBO version of the Cogswell Cog 4K."}
    :f70464d6-1b7a-4b66-8e4a-800563fef03a
    {:id :f70464d6-1b7a-4b66-8e4a-800563fef03a
     :tags ["cog" "cogswell" "intermediate"]
     :name "Cogswell Cog 4K"
     :manufacturer-id :f75691f1-21b3-44c2-b576-e7c88b563bb5
     :price 5.99
     :manufactured-time 1509976458043
     :thumbnail "cogswell-4k.png"
     :description "This is the gold standard of cogs."}
    :0613910d-466f-41e2-be09-27f433223f88
    {:id :0613910d-466f-41e2-be09-27f433223f88
     :tags ["sprocket" "spacely" "expert"]
     :name "Spacely Sprocket 9000"
     :price 4.99
     :manufacturer-id :ecacc27b-d0ec-4440-9520-568af46c34bb
     :manufactured-time 1509976458043
     :thumbnail "spacely-sprocket-9000.png"
     :description "This is the finest sprocket on the market"}
    }

   :manufacturers
   {:ecacc27b-d0ec-4440-9520-568af46c34bb
    {:id :ecacc27b-d0ec-4440-9520-568af46c34bb
     :tags ["sprocket" "spacely" "expert"]
     :name "Spacely Sprockets"
     :thumbnail "spacely-sprockets.png"
     :description "Spacely Sprockets are the best. Way better than Cogswell Cogs."}
    :f75691f1-21b3-44c2-b576-e7c88b563bb5
    {:id :f75691f1-21b3-44c2-b576-e7c88b563bb5
     :tags ["cog" "cogswell" "expert"]
     :name "Cogswell Cogs"
     :thumbnail "cogswell-cogs.png"
     :description "Cogswell makes the best cogs in the galaxy. Settle for nothing less."}
   }

   :active-filter-id nil

   :filters
   {:f50ce205-674f-4f47-bbc2-6002367c1509
    {:id :f50ce205-674f-4f47-bbc2-6002367c1509
     :fn (fn [[id widget]] (> (:price widget) 5.0))
     :name "More than 5 bucks"}

    :85a76eb8-4986-4012-913d-4f7a7110f436
    {:id :85a76eb8-4986-4012-913d-4f7a7110f436
     :fn (fn [[id widget]] (<= (:price widget) 5.0))
     :name "5 bucks or less"}

    :95a76eb8-4986-4012-913d-4f7a7110f436
    {:id :95a76eb8-4986-4012-913d-4f7a7110f436
     :fn (fn [[id widget]] (some #(= "expert" %) (:tags widget)))
     :name "Expert level"}}
  })
