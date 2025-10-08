const Error = ({ errorMsg }) => {
  return (
    <div className="w-full flex flex-col items-center mt-16 gap-4 lg:gap-8">
      <h2 className="font-bold text-2xl lg:text-3xl text-warning">
        Oops! Something went wrong.
      </h2>
      <p className="md:text-lg">
        Please forward the following message to the developer.
      </p>
      <p className="p-8 md:text-lg bg-surface text-text-light font-bold border-border border-4 shadow-gray-500 shadow-xs">
        {errorMsg}
      </p>
    </div>
  );
};

export default Error;
