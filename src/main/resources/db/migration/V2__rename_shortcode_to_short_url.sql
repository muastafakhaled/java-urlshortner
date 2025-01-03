-- update the column name from short_code to short_url
ALTER TABLE url RENAME COLUMN short_code TO short_url;