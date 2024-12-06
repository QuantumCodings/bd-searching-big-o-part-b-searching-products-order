package com.searchingsortingbigopartb.prework;

import java.util.List;

/**
 * Manages a list of AmazonPackages.
 * Individual packages can be found by ASIN.
 */
public class AmazonOrderService {

    private List<AmazonPackage> packages;

    /**
     * Constructs an AmazonOrderService object.
     * @param packages - The List of packages in the order
     */
    public AmazonOrderService(List<AmazonPackage> packages) {
        this.packages = packages;
    }

    /**
     * Does a linear search for a package in the known list of packages
     * @param asin - The ASIN being searched for.
     * @return the Amazon Package with the target ASIN
     */
    public AmazonPackage findPackageLinear(String asin) throws PackageNotFoundException {
        for(AmazonPackage amazonPackage : packages) {
            if(amazonPackage.getAsin().equals(asin)) {
                return amazonPackage;
            }
        }
        throw new PackageNotFoundException("package not found");
    }

    /**
     * Does a binary search for a package in the known list of packages
     * Note: You should assume that the package list is already sorted when this method is called.
     * @param asin - The ASIN being searched for.
     * @return the Amazon Package with the target ASIN
     */
    public AmazonPackage findPackageBinary(String asin) throws PackageNotFoundException {
        int start = 0;
        int end = packages.size() - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            AmazonPackage midPackage = packages.get(mid);
            int compare = midPackage.getAsin().compareTo(asin);
            if(compare == 0) {
                return midPackage;
            }
            else if(compare < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;

            }
        }
        throw new PackageNotFoundException();
    }
}
