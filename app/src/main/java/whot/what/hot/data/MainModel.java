package whot.what.hot.data;

import java.util.List;

/**
 * Created by sapido on 21/09/2017.
 */

public class MainModel {

    /**
     * Result : true
     * DataTable : [{"total":0},{"total":0},{"total":2}]
     * Count : 3
     * Response : 查詢各列表總數成功!
     * ErrorMessage : null
     * SqlDetail : SELECT COUNT(*) as total FROM (
     SELECT conNo=a2.CusID,
     source_list='繳款通知',
     Receipt=a1.No,type=a1.TypeName,
     explanation=a1.Gist,
     aa=a1.M_Content,
     Settime = a1.SetTime
     FROM EgsCustomer.dbo.Publish_messages a1
     LEFT OUTER JOIN EgsCustomer.dbo.Publish_Messages_Cus a2
     ON a1.No=a2.No
     UNION
     SELECT  conNo = a2.
     Id,source_list='訊息發佈',
     Receipt =a1.No,type='繳款通知',
     explanation = CASE
     WHEN a1.Cost_Style_Oth <> ''
     THEN a1.Cost_Style+'-'+a1.Cost_Style_Oth+'費用:'+cast(a1.Money AS nvarchar)
     ELSE a1.Cost_Style+'費用:'+cast(a1.Money AS nvarchar)
     END,
     aa='契約編號:'+a1.contract_no+'  '+'簽約人:'+a1.customer_name+'  '+'內容:'+P_content,
     Settime = a1.SetTime
     FROM (
     SELECT *
     FROM EgsCustomer.dbo.Payment_notification
     WHERE Payment_style='立即通知' OR Payment_style='指定時間通知' AND SetTime<=getDate()
     ) a1
     LEFT OUTER JOIN EgsCustomer.dbo.ContractCustomer_Cus a2 ON a1.contract_no=a2.ContractId
     ) AS a
     WHERE ABS(DATEDIFF(DAY,GETDATE(),a.Settime))<30 AND conNo=@CusID4 AND a.Receipt
     IN(
     SELECT DISTINCT PgNo
     FROM EgsCSApp.dbo.AppAcceptCtrl
     WHERE AppID = @AppID AND Accept='N'
     )
     UNION ALL
     SELECT COUNT(DISTINCT b.PgNo) as total
     FROM EgsCenter.dbo.AutoVoiceHandler a , EgsCSApp.dbo.AppAcceptCtrl b
     WHERE a.CusId=b.CusId AND a.CusId=@CusID AND b.AppID=@AppID2 AND b.FormNo='GZ01' AND b.Accept='N'
     UNION ALL
     SELECT COUNT(DISTINCT b.PgNo) as total
     FROM EgsCenter.dbo.AutoVoiceHandler a , EgsCSApp.dbo.AppAcceptCtrl b
     WHERE a.CusId=b.CusId AND a.CusId=@CusID2 AND b.AppID=@AppID3 AND b.FormNo='GU05' AND b.Accept='N'
     * dataDetail : null
     * secendpwd : null
     * cus_ContractDate : null
     */

    private boolean Result;
    private int Count;
    private String Response;
    private Object ErrorMessage;
    private String SqlDetail;
    private Object dataDetail;
    private Object secendpwd;
    private Object cus_ContractDate;
    private List<DataTableBean> DataTable;

    public boolean isResult() {
        return Result;
    }

    public void setResult(boolean Result) {
        this.Result = Result;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String Response) {
        this.Response = Response;
    }

    public Object getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(Object ErrorMessage) {
        this.ErrorMessage = ErrorMessage;
    }

    public String getSqlDetail() {
        return SqlDetail;
    }

    public void setSqlDetail(String SqlDetail) {
        this.SqlDetail = SqlDetail;
    }

    public Object getDataDetail() {
        return dataDetail;
    }

    public void setDataDetail(Object dataDetail) {
        this.dataDetail = dataDetail;
    }

    public Object getSecendpwd() {
        return secendpwd;
    }

    public void setSecendpwd(Object secendpwd) {
        this.secendpwd = secendpwd;
    }

    public Object getCus_ContractDate() {
        return cus_ContractDate;
    }

    public void setCus_ContractDate(Object cus_ContractDate) {
        this.cus_ContractDate = cus_ContractDate;
    }

    public List<DataTableBean> getDataTable() {
        return DataTable;
    }

    public void setDataTable(List<DataTableBean> DataTable) {
        this.DataTable = DataTable;
    }

    public static class DataTableBean {
        /**
         * total : 0
         */

        private int total;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }
}
