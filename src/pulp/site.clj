(ns pulp.site
  "Generate a static site given a source directory of templates"
  (:use
    [hiccup.core])
  (:require
    [clojure.java.io :as io])
  (:import [java.io File]))


(defn get-template-files
  "Return all the file from a given directory"
  [source-dir]
  (filter .isFile (file-seq (File. source-dir))))

(defn compile-site
  "Create a site from a given source directory."
  [source-dir]
  (let [all-files (get-template-files source-dir)
        template-files (filter #(re-matches #"\.html" %) (.getName all-files))]
    (print template-files)))
