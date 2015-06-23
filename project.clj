(defproject reagent-markdown-preview "0.1.0-SNAPSHOT"
            :description "A simple live Markdown editor with Reagent"
            :url "https://github.com/lacarmen/reagent-markdown-editor"
            :license {:name "MIT License"
                      :url  "http://opensource.org/licenses/MIT"}
            :dependencies [[org.clojure/clojure "1.6.0"]
                           [org.clojure/clojurescript "0.0-3211"]
                           [reagent "0.5.0"]]

            :source-paths ["src/clj"]

            :plugins [[lein-cljsbuild "1.0.6"]
                      [lein-figwheel "0.3.3"]]

            :hooks [leiningen.cljsbuild]

            :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

            :cljsbuild {:builds [{:source-paths ["src/cljs"]
                                  :figwheel     {:on-jsload "reagent-markdown-preview.core/main"}
                                  :compiler     {;:optimizations :advanced
                                                 :main       reagent-markdown-preview.core
                                                 :output-to  "resources/public/js/compiled/editor.js"
                                                 :output-dir "resources/public/js/compiled/out"
                                                 :asset-path "js/compiled/out"
                                                 :externs ["externs/syntax.js"]}}]})
